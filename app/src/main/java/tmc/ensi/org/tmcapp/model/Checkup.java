package tmc.ensi.org.tmcapp.model;

import java.util.Date;

public class Checkup {
    private Date date ;
    private String patientComment;
    private String doctorComment;

    public Checkup() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
