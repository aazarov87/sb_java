package task01;

import java.io.*;
import java.util.*;

import static task01.MyComparator.*;

public class CarsCompany {

    // парк автомибилей компании
    public ArrayList<Car> carsCompany = new ArrayList();

    // стоимость километра для водителей
    private final int priceKm = 5;

    // порсинг входного параметра и запись данных в carsCompany
    public void initCarsList(String str){
        int idx;
        int idxParam;

        Car car = new Car();

        idx = str.indexOf("-");
        if (idx > -1) {
            String codeCar;

            codeCar = str.substring(1, str.indexOf("_"));
            //типа ТС
            if (ListCarType.carsTypeList.containsKey(codeCar))
                car.setCarType(ListCarType.carsTypeList.get(codeCar));

            car.setStateNumber(str.substring(str.indexOf("_")+1, idx)); // номер
            idxParam = str.indexOf("-", idx + 1);

            // пробег
            if (idxParam > -1) {

                car.setMileage(Double.parseDouble(str.substring(idx + 1, str.indexOf("-", idx + 1)))); //пробег
                car.setAddParam(str.substring(idxParam + 1)); // доп параметр

            } else {
                car.setMileage(Double.parseDouble(str.substring(idx + 1)));
            }

            carsCompany.add(car);

        }

        //System.out.println(carsCompany.size());
    }

    //расчет стоимости расходов
    public void calCostConsumption(){
        //карта расходов разрезе типов ТС
        HashMap<String, Double> mapCostConsumption = new HashMap<>();

        double sumCostConsuption = 0;

        for (Car car: carsCompany
        ) {
            if (car.getDriverCompany() != null && car.getMileage() > 0) {
                System.out.println(car.toString());
                String codeCar = car.getCarType().getCode();

                //if (mapCostConsumption.containsKey(codeCar))

                double cost = car.getMileage() * car.getCarType().getСonsumption() / 100 * car.getCarType().getPriceLiterFuel();
                mapCostConsumption.put(codeCar, mapCostConsumption.getOrDefault(codeCar, (double) 0) + cost);
                sumCostConsuption = sumCostConsuption + cost;
            }
        }

        System.out.println("Общая стоимость расходов = " + sumCostConsuption);
        for (HashMap.Entry<String,Double> pair: mapCostConsumption.entrySet())
            System.out.println(pair.getKey() + " = " + pair.getValue());

        if (sumCostConsuption > 0) {
            System.out.println("Наибольший расход у ТС с кодом " + Collections.max(mapCostConsumption.entrySet(), Map.Entry.comparingByValue()).getKey());

            System.out.println("Наименьший расход у ТС с кодом " + Collections.min(mapCostConsumption.entrySet(), Map.Entry.comparingByValue()).getKey());
        }
    }

    /*
    Сортировка по коду типа ТС
     */
    public void  SortListCarbyCodeCar(String codeCar){
        //компаратор сортировки сначала по пробегу, затем по доп параметру
        Comparator<Car> comp = carMileageCompare.thenComparing(CarAddParamCompare);
        SortedMap<Car, String> sortedMap = new TreeMap<>(comp);

        //переносим данные в tree
        for (Car car : carsCompany)
            sortedMap.put(car, car.getCarType().getCode());

        for (HashMap.Entry<Car, String> pair: sortedMap.entrySet()) {
            if(pair.getValue().equals(codeCar))
                System.out.println(pair.getKey());
        }
    }

    public void initCars(String fileName){
        //System.out.println("begin initCars  this.carsCompany = " +  this.carsCompany.size());
        carsCompany.clear();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("sb_java/src/task01/data/shift/" + fileName + ".txt"))) {
            this.carsCompany = (ArrayList<Car>) in.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("end initCars");
    }

    public void updateDataFile(String fileName){
        try (FileOutputStream fileOutputStream = new FileOutputStream("sb_java/src/task01/data/shift/" + fileName)){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(carsCompany);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calcEarnShift (){
        for (Car car: carsCompany
        ) {
            if (car.getDriverCompany() != null && car.getMileage() > 0) {
                System.out.println(car.getDriverCompany().printFirstLastName() + " заработал за смену " + car.getMileage() * priceKm);
            }
        }
    }

    public void setMileage(String codeType, String stateNumber, double mileage) {
        for (Car car : carsCompany
        ) {
            if (car.getCarType().getCode().equals(codeType) && car.getStateNumber().equals(stateNumber)) {
                car.setMileage(mileage);
            }
        }
    }

    public void printAllCars() {
        for (Car car : carsCompany
        ) {
            System.out.println(car.toString());
        }
    }

    public void setDriverCar(String codeType, String stateNumber, int driverPersonalNumber){
        DriverCompany driverCompany = new DriverCompany();

        boolean isExistsCar4Driver = false;
        for (Car car : carsCompany
        ) {
            if (car.getDriverCompany() != null && car.getDriverCompany().getPersonalNumber() == driverPersonalNumber){
                System.out.println("Для водителя уже назначен авто с гос номером " + car.getStateNumber());
                isExistsCar4Driver = true;
            }
        }

        if (!isExistsCar4Driver) {
            for (Car car : carsCompany
            ) {
                if (car.getCarType().getCode().equals(codeType) && car.getStateNumber().equals(stateNumber)) {
                    System.out.println(car.toString());
                    driverCompany = ListDrivers.getDriversCompany(driverPersonalNumber);

                    if (driverCompany != null)
                        car.setDriverCompany(driverCompany);
                    else
                        System.out.println("Водитель с табельным номером " + driverPersonalNumber + " не найден");
                }
            }
        }
    }

}
