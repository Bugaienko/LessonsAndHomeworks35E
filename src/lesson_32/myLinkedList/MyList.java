package lesson_32.myLinkedList;
/*
@date 18.10.2023
@author Sergey Bugaienko
*/

public interface MyList<T> {
    void add(T value);

    void addAll(T... values);

    int size(); // количество элементов в списке

    // Находит первое вхождение
    int indexOf(T value); // возвращает индекс элемента. Если отсутствует - отрицательное число

    //  // Находит последнее вхождение
    int lastIndexOf(T value);

    // содержит ли список элемент со значением "value"
    boolean contains(T value);

    T[] toArray(); // вернуть массив из элементов списка

    // Удаление по значению. Первое вхождение с начала
    boolean remove(T value);

    // удаление по индексу
    T remove(int index);

    // Является ли коллекция пустой
    boolean isEmpty();

    // дать значение элемента по индексу
    T get(int index);


}
