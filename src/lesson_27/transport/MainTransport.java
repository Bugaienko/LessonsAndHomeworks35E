package lesson_27.transport;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

/*
Создайте иерархию классов для разных типов транспортных средств:
Vehicle (родительский класс), Car, Bicycle и Motorcycle (дочерние классы).

Родительский класс Vehicle должен иметь метод startEngine(), который не будет иметь реализации.

Дочерние классы Car, Bicycle и Motorcycle должны переопределить метод startEngine()
 для запуска соответствующего типа двигателя (если есть).

Создайте массив транспортных средств разных типов.
Используйте полиморфизм для вызова метода startEngine() для каждого транспортного средства.
 */
public class MainTransport {
    public static void main(String[] args) {

        Car car1 = new Car(new Engine(200, "Petrol"));
        Bicycle bicycle = new Bicycle();
        Motorcycle motorcycle = new Motorcycle();
        EBicycle eBicycle = new EBicycle();

        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = car1;
        vehicles[1] = bicycle;
        vehicles[2] = motorcycle;
        vehicles[3] = eBicycle;

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            vehicle.startEngine();
            System.out.println(vehicle);
            System.out.println("===============\n");
        }

        // Vehicle vehicle = new Vehicle(); нельзя создать объект абстрактного класса

    }
}
