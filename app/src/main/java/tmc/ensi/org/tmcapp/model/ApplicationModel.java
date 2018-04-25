package tmc.ensi.org.tmcapp.model;

import java.io.IOException;
import java.io.UncheckedIOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ApplicationModel {

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.105:8080/")
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
        return API.createUser(user).execute().isSuccessful();
    }

    public User login(UserCredential credential) throws IOException {
        this.currentUser = API.login(credential).execute().body();
        return currentUser;
    }
   /* public boolean updateCurrentUserChronicDisease(ChronicDisease chronicDisease) throws IOException {
        boolean updated = API.updateChronicDisease(currentUser.getIdentifier(), chronicDisease).execute().isSuccessful();
        if (updated) {
            this.currentUser.setChronicDisease(chronicDisease);
        }
        return updated;
    } */

    public boolean updateCurrentUserProfile(Profile profile) throws IOException {
        boolean updated = API.updateProfile(currentUser.getIdentifier(), profile).execute().isSuccessful();
        if (updated) {
            this.currentUser.setProfile(profile);
        }
        return updated;
    }

    public UserNotification fetchNotification() {
        try {
            return this.API.fetchNotification(this.currentUser.getIdentifier()).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private interface Api {

        @POST("users")
        Call<Void> createUser(@Body User user);

        @POST("login")
        Call<User> login(@Body UserCredential credential);

        @PUT("users/{userId}/profile")
        Call<User> updateProfile(@Path("userId") long userId, @Body Profile profile);

         //@PUT("users/{userId}/chronicDisease")
   //     Call<User> updateChronicDisease(@Path("userId") long userId, @Body ChronicDisease chronicDisease);

        @GET("notifications/{userId}")
        Call<UserNotification> fetchNotification(@Path("userId") long userId);
    }

}
