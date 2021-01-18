package task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        ArrayList arrTask = new ArrayList();

        System.out.println("Заполнения массива. exit - выход");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String s = buffer.readLine();

            if (s.equals("exit"))
                break;

            arrTask.add(Integer.parseInt(s));
        }

        ArrayListTask arrayList = new ArrayListTask(arrTask);

        System.out.println("Введите номер команды. " + "\n" +
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

            if (s.equals("1")) {
                System.out.println("Введите значение:");
                arrayList.addElement(Integer.parseInt(buffer.readLine()));
            }
            else if (s.equals("2")){
                System.out.println("Введите индекс:");
                idx = Integer.parseInt(buffer.readLine());

                System.out.println("Введите значение:");
                arrayList.addElement(idx, Integer.parseInt(buffer.readLine()));
            }
            else if (s.equals("3")){
                arrayList.PrintSize();
            }
            else if (s.equals("4")){
                System.out.println("Введите индекс:");
                arrayList.removeElement(Integer.parseInt(buffer.readLine()));
            }
            else if (s.equals("5")){
                System.out.println("Введите индекс:");
                idx = Integer.parseInt(buffer.readLine());

                System.out.println("Введите значение:");
                arrayList.setElement(idx, Integer.parseInt(buffer.readLine()));
            }
            else if (s.equals("6")){
                arrayList.Print();
            }
            else if (s.equals("7")){
                arrayList.Sort();
            }
            else if (s.equals("8")){
                arrayList.SortReverce();
            }
            else if (s.equals("9")){
                arrayList.maxElement();
            }
            else if (s.equals("10")){
                arrayList.minElement();
            }
            else if (s.equals("11")){
                System.out.println("Введите значение:");
                arrayList.setAllElement(Integer.parseInt(buffer.readLine()));
            }
        }
    }
}
