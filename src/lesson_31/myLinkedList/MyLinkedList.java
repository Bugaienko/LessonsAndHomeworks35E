package lesson_31.myLinkedList;
/*
@date 18.10.2023
@author Sergey Bugaienko
*/

import lesson_31.myArrayList.MyList;

public class MyLinkedList<T>    {

    private int size;
    private Node<T> first;
    private Node<T> last;

    // [1,2,3,4]

    // метод добавляет элемент в конец списка
    public void add(T value) {
        if (first == null) {
            // не существует ни одного узла
            first = new Node<>(value, null, null);
        } else if (last == null) {
            // существует только один узел (first)
            last = new Node<>(value, first,null);
            // следующий узел за first будет равен last
            first.next = last;
        } else {
            Node<T> temp = last;
//            System.out.println(temp.previous);
//            System.out.println(first.next);
            last = new Node<>(value, temp, null);
            temp.next = last;

            System.out.println("First: " + first);
            System.out.println("last: " + last);
            System.out.println("temp: " + temp);
            System.out.println("=================");
        }
        size++;
    }

    public String toString(){
        //TODO
        return "";
    }

    private static class Node<T> {
        T value;
        Node<T> previous;
        Node<T> next;

        public Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + (value != null ? value : "null") +
                    ", previous=" + (previous != null ? previous.value : "null") +
                    ", next=" + (next != null ? next.value : "null") +
                    '}';
        }
    }
}
