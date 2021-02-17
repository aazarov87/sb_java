package task04_3;

import java.util.*;

public class Main {

    public  static Collection<Integer> removeDuplicates(Collection<Integer> collection){
        // множество не содержит дубликатов, перекидываем в нее все значения
        Set<Integer> set = new HashSet<>(collection);

        // чистим исходную коллекцию и добавляем множество без дублей
        collection.clear();
        collection.addAll(set);

        return collection;
    }

    public static void main(String[] args) {
        Collection collection = new ArrayList();

        collection.add(1);
        collection.add(1);
        collection.add(2);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);


        // коллекция до
        for (Object col: collection
        )
            System.out.println(col);

        System.out.println("------------------");

        // удаляем дубликаты
        collection = removeDuplicates(collection);

        //коллекция после
        for (Object col: collection
             ) {
            System.out.println(col);
        }

    }
}
