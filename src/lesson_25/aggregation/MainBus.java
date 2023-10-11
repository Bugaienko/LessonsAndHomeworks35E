package lesson_25.aggregation;
/*
@date 10.10.2023
@author Sergey Bugaienko
*/

public class MainBus {
    public static void main(String[] args) {
        Passenger passenger = new Passenger("B. Smith");
//        System.out.println(passenger.toString());
//        System.out.println(passenger.getTicketNumber());

        BusDriver driver = new BusDriver("K.White", "AB-4343432");
        System.out.println(driver.toString());

        Bus bus = new Bus("Neoplan", 44, driver);
        System.out.println(bus.toString());

        //TODO вывод массива пассажиров.
        //Done отсутствие драйвера - вывод автобуса

        Bus bus1 = new Bus("Scania", 40);
        System.out.println(bus1.toString());

        Passenger passenger1 = new Passenger("N. Paul");
        Passenger passenger2 = new Passenger("J. Black");

        bus1.takePassenger(passenger);
        bus1.takePassenger(passenger2);
        bus1.takePassenger(passenger1);
        System.out.println(bus1.toString());

        bus1.dropPassenger(passenger2);
        bus.takePassenger(passenger2);
        System.out.println("Bus: " + bus.toString());
        System.out.println(bus1.toString());
        Passenger passenger3 = new Passenger("Fix ME");
        bus1.takePassenger(passenger3);
        System.out.println(bus1.toString());







    }
}



//        StringBuilder sb = new StringBuilder("Hello");
//        sb.append(124);
//        System.out.println(sb.toString());
//        sb.setLength(sb.length() - 3);
//        System.out.println(sb.toString());