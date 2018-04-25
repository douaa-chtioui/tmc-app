package tmc.ensi.org.tmcapp.model;

class DoctorAssignment {

    private String doctorCode;

    public DoctorAssignment(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }
}
