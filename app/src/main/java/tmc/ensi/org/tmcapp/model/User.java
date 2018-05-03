package tmc.ensi.org.tmcapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private long identifier;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
    private Profile profile;
    private boolean hasDoctor;
    private ChronicDisease chronicDisease;

    public User() {
    }

    public User(String email, String password, String firstname, String lastname, int age) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public long getIdentifier() {
        return identifier;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public Profile getProfile() {
        return profile;
    }

    public ChronicDisease getChronicDisease() { return chronicDisease; }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public boolean getHasDoctor() {
        return this.hasDoctor;
    }

    public void setHasDoctor(boolean hasDoctor){
        this.hasDoctor = hasDoctor;
    }

    public void setChronicDisease(ChronicDisease chronicDisease) { this.chronicDisease = chronicDisease; }

}
