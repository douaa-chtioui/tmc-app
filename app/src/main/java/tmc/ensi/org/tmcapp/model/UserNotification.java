package tmc.ensi.org.tmcapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserNotification {

    private String text;

    public UserNotification() {
    }

    public String getText() {
        return text;
    }
}
