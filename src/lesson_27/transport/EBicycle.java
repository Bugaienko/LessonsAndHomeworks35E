package lesson_27.transport;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

public class EBicycle extends Bicycle {

    public EBicycle(ElectricEngine engine) {
        setEngine(engine);
    }

    public EBicycle() {
        setEngine(new ElectricEngine(20));
    }

    @Override
    void startEngine() {
        getEngine().start();
    }

    @Override
    public String toString() {
        return "E-Bicycle {id:" + getId() + "; " + getEngine() + "}";
    }
}
