package lesson_25.homework24;
/*
@date 09.10.2023
@author Sergey Bugaienko
*/

public class InternationalBus extends Bus {

    private String[] countries;

    public InternationalBus(String model, int yearOfMan, int capacity, String[] countries) {
        super(model, yearOfMan, capacity);
        this.countries = countries;
    }

    public InternationalBus(String model, int yearOfMan, int capacity) {
        super(model, yearOfMan, capacity);
        this.countries = new String[0];
    }

    public void goToRoute(int millage) {
        System.out.println(getModel() + " отправляется по маршруту");
        // start();
        start("Italy");
        // какой-то код.
        // Посещение стран, стоянка, заправка
        stop();
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public void start(String country) {
        System.out.println("Выезжаем из " + country);
    }
}
