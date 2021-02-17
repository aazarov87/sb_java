package task04_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Main {

    public static HashMap<Integer, Collection<String>> changeMap(HashMap<String, Integer> inMap){
        // итоговая map
        HashMap<Integer, Collection<String>> hashMap = new HashMap<>();

        // коллекция для хранение значений входящей мапы
        Collection collValMap = new ArrayList();

        // значение мапы по ключу
        Integer val;

        for (HashMap.Entry<String,Integer> pair:inMap.entrySet()) {
            val  = pair.getValue();

            // если уже добавляли ключ, то добавим к нему еще одно значени
            if (hashMap.containsKey(val))
                collValMap = hashMap.get(val);
            else // иначе создадим новую коллекцию для значений по ключу
                collValMap = new ArrayList();

            collValMap.add(pair.getKey());
            hashMap.put(val, collValMap);

        }

        return hashMap;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> testMap = new HashMap<>();

        // значения для тестирования
        testMap.put("test1", 1);
        testMap.put("test2", 1);
        testMap.put("test3", 2);
        testMap.put("test4", 2);
        testMap.put("test5", 2);
        testMap.put("test6", 3);

        HashMap<Integer, Collection<String>> newMap = new HashMap<>();
        newMap = changeMap(testMap);

        // выводим результирующую мапу
        for (HashMap.Entry<Integer, Collection<String>> pair : newMap.entrySet())
            System.out.println(pair.getKey() + " = " + pair.getValue());
    }
}
