package lesson_27.transport;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

public class Motorcycle extends VehicleWithEngine{
    public Motorcycle(Engine engine) {
        super(engine);
    }

    public Motorcycle() {
        super(new Engine(50, "Petrol"));
    }

    @Override
    public String toString() {
        return "Motorcycle {id:" +
                getId() + "; "+ getEngine()+"}";
    }
}
