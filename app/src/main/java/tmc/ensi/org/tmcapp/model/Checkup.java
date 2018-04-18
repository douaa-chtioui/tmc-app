package tmc.ensi.org.tmcapp.model;

public class Checkup {
    private String name;
    private int phone ;
    public Checkup(String name , int phone)
    {this.name = name ;
        this.phone = phone ; }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
