package lesson_26.bus;
/*
@date 10.10.2023
@author Sergey Bugaienko
*/

import lesson_25.aggregation.AutoPilot;
import lesson_25.aggregation.BusDriver;
import lesson_25.aggregation.Passenger;

public class Bus {

    private final int id;
    private final String model;
    private int mileage;
    private final int capacity;

    private BusDriver driver;
    private final Passenger[] passengers;

    private final AutoPilot autoPilot; // один из вариантов инициализации -> = new AutoPilot("V.001-B");
    private int amountPassengers;
    private static int counterForId;
    private static int ticketCounter;

    public Bus(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
        this.id = counterForId++;
        passengers = new Passenger[capacity];
        this.autoPilot = new AutoPilot("V.001-B");
        // this.autoPilot.setSoftwareVersion(softwareVersionAutopilot); возможно, в конструкторе придет версия Автопилота.
    }




    public Bus(String model, int capacity, BusDriver driver) {
        this.driver = driver;
        this.model = model;
        this.capacity = capacity;
        this.id = counterForId++;
        passengers = new Passenger[capacity];
        this.autoPilot = new AutoPilot("V.001-B");
    }

    public boolean takePassenger(Passenger passenger) {
        //проверка. Если пассажир уже находится в каком-либо автобусе (имеет билет) - не пускаем его в автобус.
        if (passenger.getTicketNumber() != null){
            System.out.println("Пассажир уже находится в каком-то автобусе. Билет не продан.");
            return false;
        }

        if (amountPassengers < capacity) {
            // Done выдать билет, изменить кол-во пассажиров в автобусе
            passenger.setTicketNumber(generateTicketNumber(passenger.getId()));
            passengers[amountPassengers++] = passenger;

            return true;
        }
        return false;
    }

    public boolean dropPassenger(Passenger passenger) {
        //TODO
        // 1. Есть ли пассажир в автобусе?
        // 2. Удалить пассажира из массива
        // 3. Забрать у пассажира билет
        // 4. Уменьшить кол-во пассажиров в автобусе
        // 5. Если пассажира нет - про вернуть false

        int indexPassenger = isPassengerInBus(passenger.getId());

        if (indexPassenger >= 0) {

            //Done надо сдвигать пассажиров с индексами больше indexPassenger влево

            for (int i = indexPassenger; i < amountPassengers - 1; i++) {
                //Копируем всех пассажиров после индекса со сдвигом на 1 влево
                passengers[i] = passengers[i + 1];
            }

            //Done дублирование последнего пассажира?

//            passengers[indexPassenger] = null; эта строчка не нужна, т.к. passengers[index] был перезаписан passengers[index +1]
            passenger.setTicketNumber(null);
            passengers[amountPassengers - 1] = null;

            amountPassengers--;

            return true;
        }

        return false;
    }

    // метод проверяющий находится ли пассажи в автобусе
    private int isPassengerInBus(int idPass) {

        for (int i = 0; i < amountPassengers; i++) {
            if (passengers[i].getId() == idPass) {
                return i;
            }
        }

        return -1;
    }

    private String generateTicketNumber(int passengerId) {
        return "B" + id + "-" + passengerId + String.format("%05d", ++ticketCounter);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Bus id:").append(id).append("; model: ").append(model).append("; ");
        sb.append("capacity: ").append(capacity).append("; ");
        sb.append(" Driver: ");
        sb.append((driver == null ? "нет" : driver.toString())).append("; ");
        sb.append("Passengers: ");
        sb.append(getStringPassengerList());
        sb.append("; AP: ").append(autoPilot);
        sb.append("}");
        return sb.toString();
    }

    private String getStringPassengerList() {
        StringBuilder sb = new StringBuilder("{");
        for (Passenger passenger : passengers) {
            if (passenger != null) {
                sb.append(passenger).append("; ");
            }
        }
        // Если в sb есть хоть один пассажир -> изменить длину (отрезать два последних символа)
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("}");
        return sb.toString();
    }


    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }


    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getCapacity() {
        return capacity;
    }

    public BusDriver getDriver() {
        return driver;
    }

    public void setDriver(BusDriver driver) {
        this.driver = driver;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }
}
