package lesson_30.generics;
/*
@date 17.10.2023
@author Sergey Bugaienko
*/

public interface Calculated <T extends Number>{
    T sum(T v1, T v2);
    default void printValue(T value) {
        System.out.println(value.intValue());
    }

}
