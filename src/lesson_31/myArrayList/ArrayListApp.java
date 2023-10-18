package lesson_31.myArrayList;
/*
@date 18.10.2023
@author Sergey Bugaienko
*/

public class ArrayListApp {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.addAll(10, -45, 24, 0, 128, 15);
        System.out.println(list);
        System.out.println(list.isEmpty());
        Integer val = list.get(4);
        System.out.println("val: " + val);
        list.remove(Integer.valueOf(128));
        System.out.println(list);

        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add("Hello");
        stringList.addAll("Java", "hello");
        System.out.println(stringList);
//        stringList.remove("Hello");
        stringList.remove(new String("Hello"));

        System.out.println(stringList);


    }
}
