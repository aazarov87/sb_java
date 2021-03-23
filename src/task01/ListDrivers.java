package task01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Список водителей компании
 */
public class ListDrivers {

    //файл для чтения данных
    private static final String fileData = "sb_java/src/task01/data/driversCompany.txt";

    // MAP водителей компании
    /*
    Integer - табельный номер
     */
    private static HashMap<Integer, DriverCompany> DriversCompany = new HashMap<Integer, DriverCompany>();

    private static void updateDataFile(){
        try(ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream(fileData))){
            out.writeObject(DriversCompany);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addDriverCompany(String firstName, String lastName, int age, int personalNumber){
        if (DriversCompany.containsKey(personalNumber))
            System.out.println("Водитель с табельным номером " + personalNumber + " уже существует");
        else {
            DriversCompany.put(personalNumber, new DriverCompany(firstName, lastName, age, personalNumber));
            updateDataFile();
        }
    }

    public static void delDriverCompany(int personalNumber){
        if (!DriversCompany.containsKey(personalNumber))
            System.out.println("Водитель с табельным номером " + personalNumber + " НЕ существует");
        else {
            DriversCompany.remove(personalNumber);
            updateDataFile();
        }
    }

    public static void initListDriversCompany(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileData))) {
            DriversCompany = (HashMap<Integer, DriverCompany>) in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Нет водителей");
        }
    }

    public static void printDriversCompany(){
        if (DriversCompany.size() == 0){
            initListDriversCompany();
        }

        for (Map.Entry<Integer, DriverCompany> pair: DriversCompany.entrySet())
            System.out.println(pair.getKey() + ": " + pair.getValue());
    }

    public static DriverCompany getDriversCompany(int personalNumber){
        DriverCompany driverCompany = new DriverCompany();

        if (DriversCompany.size() == 0){
            initListDriversCompany();
        }

        for (Map.Entry<Integer, DriverCompany> pair: DriversCompany.entrySet()) {
            if (pair.getValue().getPersonalNumber() == personalNumber) {
                System.out.println(pair.getKey() + ": " + pair.getValue());
                driverCompany = pair.getValue();
                break;
            }

        }

        return driverCompany;
    }


}
