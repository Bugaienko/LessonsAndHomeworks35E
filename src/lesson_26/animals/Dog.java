package lesson_26.animals;
/*
@date 11.10.2023
@author Sergey Bugaienko
*/

public class Dog extends Animal {

    String name = "Max";

    public Dog(String name) {
        super(name);
        this.name = name;
    }

    public Dog() {

    }

    public void setName(String name) {
        this.name = name;
    }

    // переопределение родительского методы
    @Override
    public void sound() {
        System.out.println(name + " say Woof!");
    }

    // переопределение перегруженному у родителя метода
    @Override
    public void sound(String string) {
        System.out.println("Dog say: " + string);
    }


    public void sound(int amount) {
        sound(String.valueOf(amount));
    }

    public void jump() {
        System.out.println("Dog jumping");
    }

    @Override
    public String toString(){
        return "{Dog: " + name + "}";
    }



    @Override
    public boolean equals(Object obj) {
        System.out.println("Equals Dog");
        if (this == obj) return true;
        if (obj instanceof Dog) {
            Dog temp = (Dog) obj;
            return this.name.equals(temp.name);
        } return false;
    }
}
