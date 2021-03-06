package tmc.ensi.org.tmcapp.model;

import java.util.Date;

public class Checkup {

    private long identifier;
    private String patientFullName;
    private Date checkupDate;
    private String patientComment;
    private String doctorComment;
    private Profile patientProfile;

    public Checkup() {

    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public Date getCheckupDate() {
        return checkupDate;
    }

    public void setCheckupDate(Date checkupDate) {
        this.checkupDate = checkupDate;
    }

    public String getPatientComment() {
        return patientComment;
    }

    public void setPatientComment(String patientComment) {
        this.patientComment = patientComment;
    }

    public String getDoctorComment() {
        return doctorComment;
    }

    public void setDoctorComment(String doctorComment) {
        this.doctorComment = doctorComment;
    }

    public Profile getPatientProfile() {
        return patientProfile;
    }

    public void setPatientProfile(Profile patientProfile) {
        this.patientProfile = patientProfile;
    }
}
