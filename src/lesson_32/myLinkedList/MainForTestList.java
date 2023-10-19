package lesson_32.myLinkedList;
/*
@date 19.10.2023
@author Sergey Bugaienko
*/

public class MainForTestList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        list.add("1");

        System.out.println(list);
        list.addFirst("0");
        System.out.println(list);
//        System.out.println(list.size());
        System.out.println(list.lastIndexOf("0"));
        System.out.println("==========remove==========\n");
        System.out.println(list);
//        list.remove();
        list.removeLast();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list);




    }
}
