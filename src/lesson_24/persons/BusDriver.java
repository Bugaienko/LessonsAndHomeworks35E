package lesson_24.persons;
/*
@date 09.10.2023
@author Sergey Bugaienko
*/

public class BusDriver extends Person{

    private String driveLicence;

    private final int id;
    private static int counter = 100;

    public BusDriver(String name, int age, String driveLicence){
        super(name, age);
        this.driveLicence = driveLicence;
        this.id = counter++;
    }

    public void  driverInfo() {
        System.out.println("BusDriver "+ getName() + " id:" + id
                + " (права номер: " + driveLicence + "); возраст: " + getAge());
    }

    public String getDriveLicence() {
        return driveLicence;
    }

    public void setDriveLicence(String driveLicence) {
        this.driveLicence = driveLicence;
    }

    public int getId() {
        return id;
    }

}
