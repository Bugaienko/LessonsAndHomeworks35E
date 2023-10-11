package lesson_24.persons;
/*
@date 09.10.2023
@author Sergey Bugaienko
*/

public class MainPersons {

    public static void main(String[] args) {
        Passenger passenger =
                new Passenger("Max", 14, 15054);

        passenger.info();

        passenger.passengerInfo();
        passenger.setAge(15);
        passenger.passengerInfo();

        System.out.println("\n======================");

        Passenger passenger1 =
                new Passenger("Bob", 25, 15057);

        System.out.println(passenger1.getId());
        passenger1.passengerInfo();
        System.out.println(passenger1.getName());

        System.out.println("\n======================");


        BusDriver driver = new BusDriver("John", 45, "Ad-G 1231412");

        driver.info();
        driver.driverInfo();
        System.out.println(driver.getId());



    }
}
