package lesson_24.persons;
/*
@date 09.10.2023
@author Sergey Bugaienko
*/

public class Passenger extends Person {

    private final int id;
    private int ticketNumber;
    //Проблема. Поле устанавливается 1 раз в конструкторе. Сеттер поля age может изменить возраст.
    // Родительский метод setAge ничего не знает о поле наследника isKind -> не может его поменять
    private boolean isKind;
    //TODO решить проблему изменения возраста в сеттере

    private static int counter;


    public Passenger(String name, int age, int ticketNumber){
        super(name, age);
        this.id = counter++;
        this.ticketNumber = ticketNumber;
        this.isKind = age < 15;
    }

    public void passengerInfo() {
        System.out.print("Passenger id:" + id + " (билет №:" + ticketNumber + "), isKind: " + (isKind ? "Да" : "Нет")+ " : ");
        super.info();

    }

    public int getId() {
        return id;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }


}
