package tmc.ensi.org.tmcapp.model;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class ApplicationModel {

    private static final Retrofit retrofit = new Retrofit.Builder()

//            .baseUrl("http://192.168.0.10:8080/")
            .baseUrl("http://192.168.1.102:8080/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    private static final Api API = retrofit.create(Api.class);

    private static final ApplicationModel instance = new ApplicationModel();

    private User currentUser;

    private ApplicationModel() {

    }

    public static ApplicationModel get() {
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean createUser(User user) throws IOException {
        return API.createPatient(user).execute().isSuccessful();
    }

    public User login(UserCredential credential) throws IOException {
        this.currentUser = API.login(credential).execute().body();
        return this.currentUser;
    }

    public boolean updateCurrentUserProfile() throws IOException {
        return API.updatePatientProfile(currentUser.getIdentifier(), currentUser.getProfile()).execute().isSuccessful();
    }

    public boolean updateCurrentChronicDisease() throws IOException {
        return API.updatePatientChronicDisease(currentUser.getIdentifier(), currentUser.getChronicDisease()).execute().isSuccessful();
    }

    public UserNotification fetchNotification() {
        try {
            return API.fetchNotification(this.currentUser.getIdentifier()).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean assignDoctor(String doctorCode) {
        try {
            boolean successful = API.assignDoctor(this.currentUser.getIdentifier(), new DoctorAssignment(doctorCode)).execute().isSuccessful();
            if (successful) {
                this.currentUser.setHasDoctor(true);
            }
            return successful;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createCheckup(Checkup checkup) throws IOException {
        boolean successful = API.createCheckup(this.currentUser.getIdentifier(), checkup).execute().isSuccessful();
        if (successful) {
            this.currentUser.getCheckups().add(checkup);
        }
        return successful;
    }

    public boolean updateCheckup(long checkupId, Comment comment) throws IOException {
        boolean successful = API.updateCheckup(checkupId, comment).execute().isSuccessful();
        if (successful) {
            for (Checkup checkup : this.currentUser.getCheckups()) {
                if (checkup.getIdentifier() == checkupId) {
                    checkup.setDoctorComment(comment.getValue());
                }
            }
        }
        return successful;
    }

    private interface Api {

        @POST("patients")
        Call<Void> createPatient(@Body User user);

        @POST("login")
        Call<User> login(@Body UserCredential credential);

        @PUT("patients/{patientId}/profile")
        Call<Void> updatePatientProfile(@Path("patientId") long patientId, @Body Profile profile);

        @PUT("patients/{patientId}/doctor")
        Call<Void> assignDoctor(@Path("patientId") long patientId, @Body DoctorAssignment doctorAssignment);

        @GET("notifications")
        Call<UserNotification> fetchNotification(@Query("patientId") long patientId);

        @PUT("patients/{patientId}/chronic-disease")
        Call<Void> updatePatientChronicDisease(@Path("patientId") long identifier, @Body ChronicDisease chronicDisease);

        @POST("patients/{patientId}/checkups")
        Call<Void> createCheckup(@Path("patientId") long patientId, @Body Checkup checkup);

        @PUT("/checkups/{checkupId}")
        Call<Void> updateCheckup(@Path("checkupId") long checkupId, @Body Comment comment);

    }

}
