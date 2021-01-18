package task02;

import java.util.*;

public class ArrayListTask {

    private ArrayList arrTask;

    public ArrayListTask(ArrayList arr) throws CloneNotSupportedException {
        arrTask = (ArrayList) arr.clone();
    }

    public void Print(){
        System.out.println("Массив");
        System.out.println(arrTask.toString());
    }

    public void Sort() throws CloneNotSupportedException {
        System.out.println("Сортировка по возрвстанию");
        ArrayList arr = (ArrayList) arrTask.clone();
        Collections.sort(arr);
        System.out.println(arr.toString());
    }

    public void SortReverce() throws CloneNotSupportedException {
        System.out.println("Сортировка по убыванию");
        ArrayList arr = (ArrayList) arrTask.clone();
        Collections.sort(arr,  Collections.reverseOrder());
        System.out.println(arr.toString());
    }

    public void PrintSize(){
        System.out.println("Размер массива");
        System.out.println(arrTask.size());
    }

    public void addElement(int idx, int val){
        if (idx > 0 && idx <= arrTask.size())
            arrTask.add(idx-1, val);
        else
            System.out.println("Индекс вне диапазона размера массива");
    }

    public void addElement(int val){
        arrTask.add(val);
    }

    public void removeElement(int idx){
        if (idx > 0 && idx <= arrTask.size())
            arrTask.remove(idx-1);
        else
            System.out.println("Индекс вне диапазона размера массива");
    }

    public void setElement(int idx, int val){
        if (idx > 0 && idx <= arrTask.size())
            arrTask.set(idx-1, val);
        else
        System.out.println("Индекс вне диапазона размера массива");
    }

    public void setAllElement(int val){
        for(int i = 1; i <= arrTask.size(); i++) {
            setElement(i, val);
        }

    }

    public void maxElement(){
        int max = 0;
        for(int i = 0; i < arrTask.size(); i++) {
            int val = (int) arrTask.get(i);
            if (max < val)
                max = val;
        }

        System.out.println("Максимальный элемент = " + max);
    }

    public void minElement(){
        int min = 0;
        for(int i = 0; i < arrTask.size(); i++) {
            int val = (int) arrTask.get(i);
            if (i==0)
                min = val;
            else {
                if (min > val)
                    min = val;
            }
        }

        System.out.println("Минимальный элемент = " + min);
    }
}
