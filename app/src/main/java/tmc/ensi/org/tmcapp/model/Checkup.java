package tmc.ensi.org.tmcapp.model;

public class Checkup {
    private String name;
    private String date ;
    public Checkup(String name , String date)
    {this.name = name ;
        this.date = date ; }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
