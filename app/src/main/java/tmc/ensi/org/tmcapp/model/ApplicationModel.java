package tmc.ensi.org.tmcapp.model;

import android.util.Log;

import java.io.IOException;

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
            .baseUrl("http://192.168.100.44:8080/")
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

    public boolean updateCurrentUserProfile(Profile profile) throws IOException {
        boolean updated = API.updatePatientProfile(currentUser.getIdentifier(), profile).execute().isSuccessful();
        if (updated) {
            this.currentUser.setProfile(profile);
        }
        return updated;
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

    private interface Api {

        @POST("patients")
        Call<Void> createPatient(@Body User user);

        @POST("login")
        Call<User> login(@Body UserCredential credential);

        @PUT("patients/{patientId}/profile")
        Call<User> updatePatientProfile(@Path("patientId") long patientId, @Body Profile profile);

        @PUT("patients/{patientId}/doctor")
        Call<User> assignDoctor(@Path("patientId") long patientId, @Body DoctorAssignment doctorAssignment);

        @GET("notifications")
        Call<UserNotification> fetchNotification(@Query("patientId") long patientId);

    }

}
