package lesson_32.myLinkedList;
/*
@date 19.10.2023
@author Sergey Bugaienko
*/

public class MyLinkedListApp {
    public static void main(String[] args) {
        MyLinkedList<String> strings = new MyLinkedList<>();
        System.out.println(strings);
        System.out.println(strings.indexOf("1"));
        strings.add("1"); // [1]  - first

        System.out.println(strings);
        System.out.println("Сейчас только один элемент в списке (\"1\"). " + strings.lastIndexOf("1"));
        strings.add("2"); // [1, 2]

        strings.add("3");
        strings.add("4");
        strings.addAll("Abc", "hello");
        strings.add("Abc");

        System.out.println(strings);
        System.out.println(strings.indexOf("4"));
        System.out.println(strings.indexOf("FDDF"));
        System.out.println("============= indexOf ==========");
        System.out.println("indexOf: " + strings.indexOf("Abc"));
        System.out.println("lastIndexOf: " + strings.lastIndexOf("Abc"));
        System.out.println("last V2: " + strings.lastIndexOfV2("Abc"));

//        MyList<Integer> list = new MyLinkedList<>();
//        Queue<Integer> queue = new MyLinkedList<>();
        strings.addFirst("0");
        System.out.println(strings);





    }
}
