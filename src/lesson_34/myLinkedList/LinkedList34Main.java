package lesson_34.myLinkedList;
/*
@date 23.10.2023
@author Sergey Bugaienko
*/

import lesson_31.myArrayList.MyArrayList;

import java.util.Arrays;
import java.util.Iterator;

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

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();

//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }



        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String val = iterator.next();


        }

        System.out.println(list);


        //for-each под "капотом" работает именно так.
        // в цикл for-each мы можем использовать только класс реализующий интерфейс Iterable
        for (String val: list){
            System.out.print(val + ", ");
        }


        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addAll(1,2,3,4,5,6);

//        for (Integer val: myArrayList){
//            System.out.println(val);
//        }



    }
}
