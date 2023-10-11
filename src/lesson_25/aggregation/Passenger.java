package lesson_25.aggregation;
/*
@date 10.10.2023
@author Sergey Bugaienko
*/

public class Passenger {

    private final int id;
    private String name;
    private String ticketNumber;


    private static int counter = 1;

//    public Passenger(String name, String ticketNumber) {
//        this.name = name;
//        this.ticketNumber = ticketNumber;
//        this.id = counter++;
//    }

    public Passenger(String name) {
        this.name = name;
        this.id = counter++;
    }

    public String toString() {
        return "{Passenger id:" + id + "; name: " + name+ "; " + (ticketNumber != null ? "ticket: " + ticketNumber : "") + "}";
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

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
