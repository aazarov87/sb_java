package task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("введите количество элементов массива");
        int n = 0;
        int idxArr = 0;
        n = Integer.parseInt(buffer.readLine());
        int[] arrTask = new int[n];

        System.out.println("введите значения");
        while (true)
        {
            String s = buffer.readLine();

            arrTask[idxArr] = Integer.parseInt(s);
            idxArr += 1;

            if (arrTask.length == idxArr)
                break;
        }

        ArrayListTask02 arrayList = new ArrayListTask02(arrTask);

        System.out.println("Введите номер команды: " + "\n" +
                "1 - добавление элемента(в конец)" + "\n" +
                "2 - добавление элемента(по индексу)" + "\n" +
                "3 - количества элементов" + "\n" +
                "4 - удаление элемента массива по индексу" + "\n" +
                "5 - изменение элемента массива по индексу" + "\n" +
                "6 - вывод на экран всего массива" + "\n" +
                "7 - сортировка массива по возрастанию" + "\n" +
                "8 - сортировка массива по убыванию" + "\n" +
                "9 - max элемент" + "\n" +
                "10 - min элемент" + "\n" +
                "11 - заполнение массива одинаковыми элементами" + "\n" +
                "exit - выход");
        while (true)
        {
            String s = buffer.readLine();
            int idx;

            if (s.equals("exit"))
                break;

            switch (s) {
                case "1" -> {
                    System.out.println("Введите значение:");
                    arrayList.addEndElement(Integer.parseInt(buffer.readLine()));
                }
                case "2" -> {
                    System.out.println("Введите индекс:");
                    idx = Integer.parseInt(buffer.readLine());
                    System.out.println("Введите значение:");
                    arrayList.addElement(idx, Integer.parseInt(buffer.readLine()));
                }
                case "3" -> arrayList.printSize();
                case "4" -> {
                    System.out.println("Введите индекс:");
                    arrayList.delElement(Integer.parseInt(buffer.readLine()));
                }
                case "5" -> {
                    System.out.println("Введите индекс:");
                    idx = Integer.parseInt(buffer.readLine());
                    System.out.println("Введите значение:");
                    arrayList.setElement(idx, Integer.parseInt(buffer.readLine()));
                }
                case "6" -> arrayList.print();
                case "7" -> arrayList.sort();
                case "8" -> arrayList.sortReverce();
                case "9" -> arrayList.maxElement();
                case "10" -> arrayList.minElement();
                case "11" -> {
                    System.out.println("Введите значение:");
                    arrayList.setAllElement(Integer.parseInt(buffer.readLine()));
                }
            }
        }
    }
}
