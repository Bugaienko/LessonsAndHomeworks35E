package lesson_49.hashMapImp;
/*
@date 14.11.2023
@author Sergey Bugaienko
*/

public class HashMapApp {
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();

        System.out.println("value: " + map.put(5, "Str"));
        System.out.println("=========================");
        System.out.println("value: " + map.put(21, "Python"));
        System.out.println(map + " size: " + map.size());
        System.out.println("value: " + map.put(21, "Java"));

        System.out.println(map + " size: " + map.size());

        System.out.println(map.put(null, "test"));
        System.out.println(map + " size: " + map.size());
        System.out.println(map.put(null, "orange"));
        map.put(0, "zero");
        System.out.println(map + " size: " + map.size());
        map.put(16, "Apple");
        map.put(17, "Asus");
        System.out.println(map + " size: " + map.size());

        System.out.println("21: " + map.get(21));
        System.out.println("16: " + map.get(16));
        System.out.println("null: " + map.get(null));
        System.out.println("0: " + map.get(0));

        System.out.println(map + " size: " + map.size());
        map.put(37, "Banana");
        map.put(9, "Cat");
        map.put(11, "Robot");
        map.put(43, "Map");
        map.put(25, "Tree");
        System.out.println(map + " size: " + map.size());
        map.put(8, "Red");
        System.out.println(map + " size: " + map.size());
        map.put(-15, "minus");
        map.put(-1, "minus");
        System.out.println(map + " size: " + map.size());


    }
}
