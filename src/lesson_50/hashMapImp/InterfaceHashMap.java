package lesson_50.hashMapImp;

import java.util.Collection;
import java.util.Set;

public interface InterfaceHashMap<K, V>{
    // Положить в карту пару ключ-значение. Если ключ уже существует - обновить значение
    V put(K key, V value);

    // Взять из карты значение, соответсвующее ключу. Если ключ отсутствует - возвращаем null
    V get(Object key);

//    //Удалить пару ключ-значение
    V remove(Object key);

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);
    void clear();
    Set<K> keySet();
    Collection<V> values();
    V getOrDefault(Object key, V defaultValue);
}