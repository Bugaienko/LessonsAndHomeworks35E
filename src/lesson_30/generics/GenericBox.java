package lesson_30.generics;
/*
@date 17.10.2023
@author Sergey Bugaienko
*/

// public class GenericBox<T extends Number> { ограничение типа сверху. При создании объекта я могу укзать этот класс или его наследников
public class  GenericBox<T> {
    private T value;

    public GenericBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value){

        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericBox{" +
                "value=" + value +
                '}';
    }

}
