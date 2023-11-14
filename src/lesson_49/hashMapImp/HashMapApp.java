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





    }
}
