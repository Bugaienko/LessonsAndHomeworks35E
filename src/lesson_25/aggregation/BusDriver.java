package lesson_25.aggregation;
/*
@date 10.10.2023
@author Sergey Bugaienko
*/

public class BusDriver {

    private final int  id;
    private String name;
    private String driveLicence;

    private static int counter;

    public BusDriver(String name, String driveLicence) {
        this.name = name;
        this.driveLicence = driveLicence;
        this.id = counter++;
    }


    public String toString() {
        return "{BusDriver id:" + id + "; name: " + name + "; Licence: " + driveLicence + "}";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriveLicence() {
        return driveLicence;
    }

    public void setDriveLicence(String driveLicence) {
        this.driveLicence = driveLicence;
    }
}
