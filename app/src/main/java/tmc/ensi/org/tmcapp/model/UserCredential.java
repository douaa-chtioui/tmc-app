package tmc.ensi.org.tmcapp.model;

public class UserCredential {

    private String email;
    private String password;

    public UserCredential(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
