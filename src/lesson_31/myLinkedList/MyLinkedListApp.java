package lesson_31.myLinkedList;
/*
@date 18.10.2023
@author Sergey Bugaienko
*/

public class MyLinkedListApp {
    public static void main(String[] args) {
        MyLinkedList<String> strings = new MyLinkedList<>();
        strings.add("1"); // [1]  - first
        strings.add("2"); // [1, 2]

        strings.add("3");
        strings.add("4");
    }
}
