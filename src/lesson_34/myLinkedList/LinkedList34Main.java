package lesson_34.myLinkedList;
/*
@date 23.10.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;

public class LinkedList34Main {
    public static void main(String[] args) {

        MyLinkedList<String> list = new MyLinkedList<>();
//        list.addAll("Java");
        list.addAll("String", "Hello", "Java", "Three");
        System.out.println(list);
        System.out.println("get: " + list.get(0));
        System.out.println("contains: " + list.contains("Java"));
        System.out.println("remove: " + list.remove("Java"));
        System.out.println(list);
        list.add("Python");
        System.out.println(list);
        System.out.println("remove: " + list.remove(2));
        System.out.println(list);
        System.out.println(list.size());

        String[] strings =  list.toArray();
        System.out.println(Arrays.toString(strings));
    }
}
