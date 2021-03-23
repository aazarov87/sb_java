package task01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Класс справочных данных по типам ТС
 */
public class ListCarType {

    //карта типов ТС
    public static HashMap<String, CarType> carsTypeList = new HashMap<>();

    //файл для чтения данных
    private static final String fileData = "sb_java/src/task01/data/carType1.txt";

    public static void initCarTypeFromFile(){
        //System.out.println("begin initCarTypeFromFile");

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileData))) {
            carsTypeList = (HashMap<String, CarType>) in.readObject();

        } catch (ClassNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printCarType(){
        if (carsTypeList.size() <= 0)
            initCarTypeFromFile();

        for (Map.Entry<String, CarType> pair: carsTypeList.entrySet())
            System.out.println(pair.getKey() + ": " + pair.getValue());
    }

    private static void updateDataFile(){
        try(ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream(fileData))){
            out.writeObject(carsTypeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addCarType(String code, String name, double сonsumption, double priceLiterFuel){
        if (carsTypeList.containsKey(code))
            System.out.println("Тип ТС с кодом " + code + " уже существует");
        else {
            carsTypeList.put(code, new CarType(code, name, сonsumption, priceLiterFuel));
            updateDataFile();
        }
    }

    public static void delCarType(String code){
        if (!carsTypeList.containsKey(code))
            System.out.println("Тип ТС с кодом " + code + " НЕ существует");
        else {
            carsTypeList.remove(code);
            updateDataFile();
        }
    }


}
