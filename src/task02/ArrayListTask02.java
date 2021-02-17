package task02;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTask02 {

    public int[] arrList;

    public ArrayListTask02(int[] arr){
        this.arrList = arr;
    }

    private void printOut(int[] arr, boolean bReverce){
        System.out.println("Массив");

        if (bReverce){
            for (int i = arr.length-1; i >=0; i--) {

                System.out.print(arr[i]);
                if ((i > 0) && (arr.length != 1))
                    System.out.print(", ");
            }
        }else {
            for (int i = 0; i < arr.length; i++) {

                System.out.print(arr[i]);
                if ((i < arr.length - 1) && (arr.length != 1))
                    System.out.print(", ");
            }
        }

        System.out.println();
    }

    public void print(){
        printOut(arrList, false);
    }

    private int[] getSortArr(){
        int[] arr = new int[arrList.length];
        System.arraycopy(arrList, 0, arr, 0, arrList.length);

        for (int out = arr.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(arr[in] > arr[in + 1]) {
                    int dummy = arr[in];
                    arr[in] = arr[in+1];
                    arr[in+1] = dummy;
                }
            }
        }

        return arr;
    }

    public void sort(){
        System.out.println("Сортировка по возрастанию");
        printOut(this.getSortArr(), false);
    }


    public void sortReverce() {
        System.out.println("Сортировка по убыванию");
        printOut(this.getSortArr(), true);
    }

    public void addElement(int idx, int val){
        if (idx > 0 && idx <= arrList.length+1) {
            int[] arrTemp = new int[arrList.length + 1];

            if (idx == arrList.length) {

                System.arraycopy(arrList, 0, arrTemp, 0, arrList.length);
                arrTemp[arrList.length] = val;
                this.arrList = arrTemp;
            }else{
                System.arraycopy(arrList, 0, arrTemp, 0, idx-1);

                arrTemp[idx-1] = val;

                System.arraycopy(arrList, idx-1, arrTemp, idx, arrList.length -idx + 1);

                arrList = new int[arrTemp.length];
                System.arraycopy(arrTemp, 0, arrList, 0, arrTemp.length);
            }

        } else
            System.out.println("Индекс вне диапазона размера массива");
    }

    public void addEndElement(int val){
        addElement(arrList.length, val);
    }

    public void delElement(int idx){
        if (idx > 0 && idx <= arrList.length) {
            int[] arrTemp = new int[arrList.length-1];

            if (idx != 1)
                System.arraycopy(arrList, 0, arrTemp, 0, idx-1);

            System.arraycopy(arrList, idx, arrTemp, idx-1, arrList.length-idx);

            this.arrList = arrTemp;
        } else
            System.out.println("Индекс вне диапазона размера массива");
    }

    public void printSize(){
        System.out.println("Размер массива");
        System.out.println(this.arrList.length);
    }

    public void setElement(int idx, int val){
        if (idx > 0 && idx <= this.arrList.length)
            arrList[idx-1] = val;
        else
            System.out.println("Индекс вне диапазона размера массива");
    }

    public void maxElement(){
        int max = 0;
        for(int i = 0; i < this.arrList.length; i++) {
            int val = (int) arrList[i];
            if (max < val)
                max = val;
        }

        System.out.println("Максимальный элемент = " + max);
    }

    public void minElement(){
        int min = 0;
        for(int i = 0; i < arrList.length; i++) {
            int val = (int) arrList[i];
            if (i==0)
                min = val;
            else {
                if (min > val)
                    min = val;
            }
        }

        System.out.println("Минимальный элемент = " + min);
    }

    public void setAllElement(int val){
        for(int i = 1; i <= arrList.length; i++) {
            setElement(i, val);
        }

    }
}
