package lesson_26.animals;
/*
@date 11.10.2023
@author Sergey Bugaienko
*/

public class Hamster extends Animal{

//    public Hamster(){
//        super();
//    }

    @Override
    public void sound() {
        System.out.println("Hamster say hrum-hrum");
    }

    @Override
    public String toString() {
        return "Хомяк";
    }
}
