package lesson_32.myLinkedList;
/*
@date 19.10.2023
@author Sergey Bugaienko
@version 0.2
*/

public class MyLinkedList<T> implements MyList<T>, Queue<T> {

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
            last = new Node<>(value, first, null);
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



    // @Override
    public void addLast(T value) {
        add(value);
    }

    // Добавить элемент в начало списка
    // @Override
    public void addFirst(T value) {

        if (first == null) {
            // Если список пустой
            first = new Node<>(value, null, null);
        } else if (last == null) {
            // кейс: есть только 1 нода.
            last = first;
            first = new Node<>(value, null, last);
            last.previous = first;
        } else {
            // остальные состояния списка
            Node<T> temp = first;
            first = new Node<>(value, null, temp);
            temp.previous = first;
        }

        size++;
    }

    // Удалить самый(первый) левый узел
    // @Override
    public T remove() {
        if (size == 0) return null;
        // если в списке есть ноды, то удаляться будет нода first
        // записываем ее значение для возврата из метода
        T value = first.value;
        if (size == 1) {
            // Если в списке только 1 нода (first)
            first = null;

        }
        else if (size == 2) {
            // в списке 2 ноды (first и last)
            first = last;
            first.previous = null;
            last = null;
        }
        else {
            // больше 2х нод
            first = first.next;
            first.previous = null;
        }

        size--;
        return value;
    }

    //@Override
    public T removeFirst() {
        return remove();
    }

    // @Override
    public T removeLast() {
        if (size == 0) return null;
        T value;
        if (size == 1) {
            // только нода first
            value = first.value;
            first = null;
        } // сценарии, в которых мы удаляем ноду last
        else if (size == 2) {
            // есть две ноды
            value = last.value;
            last = null;
            first.next = null;
        }
        else {
            value = last.value;
            last = last.previous;
            last.next = null;
        }


        size--;
        return value;
    }

    //@Override
    public T getFirst() {
        return (first == null ? null : first.value);
    }

    //@Override
    public T getLast() {
        //TODO переписать. Если в листе только 1 элемент - вернуть его значение
        T value = null;
        if (last != null) {
            value = last.value;
        }
        return value;
    }

    //    @Override
    public void addAll(T... values) {
        for (T value : values) {
            add(value);
        }
    }

    //    @Override
    public int size() {
        return size;
    }

    //@Override
    public boolean isEmpty() {
        return size == 0;
    }

    //    @Override
    public int indexOf(T value) {
        int index = 0;
        // перебираем список, начиная с головы
        Node<T> cursor = first;
        while (cursor != null) {
            if (cursor.value.equals(value)) {
                return index;
            }
            index++;
            cursor = cursor.next;
        }
        return -1;
    }

    public int lastIndexOfV2(T value) {
        int result = -1;
        int index = 0;
        Node<T> cursor = first;
        while (cursor != null) {
            if (cursor.value.equals(value)) {
                result = index;

            }
            index++;
            cursor = cursor.next;
        }

        return result;
    }


    // Индекс последнего (самого правого) вхождения элемента
    //@Override
    public int lastIndexOf(T value) {
        if (size == 0) return -1;
        int index = size - 1;
        Node<T> cursor = last;
        while (cursor != null) {
            if (cursor.value.equals(value)) {
                return index;
            }
            index--;
            cursor = cursor.previous;
        }

        // обрабатываем кейс - когда у нас только 1 элемент
        if (size == 1) {
            if (first.value.equals(value)) {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (first != null) {
            sb.append(first.value);
            Node<T> cursor = first.next;
            while (cursor != null) {
                sb.append(", ");
                sb.append(cursor.value);
                cursor = cursor.next;
            }
        }

        sb.append("]");
        return sb.toString();
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
