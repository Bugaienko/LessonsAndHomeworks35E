package lesson_20;
/*
@date 02.10.2023
@author Sergey Bugaienko
*/

public class MainDog {
    public static void main(String[] args) {

        Dog dog = new Dog("Max", 54);

        System.out.println(dog.toString());

//        System.out.println("Собака, которую зовут: " + dog.getName());
//        System.out.println("Собака умеет прыгать на: " + dog.getJumpHeight()
//                + " сантиметров" );

        int[] barriers = {50, 150, 85, 120, 107, 112};

        int countTaken = 0;

        for (int barrier: barriers) {
            System.out.println("Новый барьер: " + barrier);
            boolean isTaken =  dog.takeBarrier(barrier);
            if (isTaken) countTaken++;
            System.out.println("===========================\n");
        }

        System.out.println("\nСобака преодолела " + countTaken + " барьеров");

    }
}
