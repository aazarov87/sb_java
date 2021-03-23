package task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Меню пользователя
 */
public class MenuUser {
    private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    private static File fileShift;

    private static void printMenu(){
        System.out.println(
                "1 - Общая стоимость расходов и расход в разрезе каждого типа ТС" + "\n" +
                "    Тип с наибольшей стоимость расходов" + "\n" +
                "    Тип с наименьшей стоимость расходов" + "\n" +
                "2 - Вывести информацию по типу ТС" + "\n" +
                "3 - Открыть смену" + "\n" +
                "4 - Распределить водителей по машинам" + "\n" +
                "5 - Посмотреть список смен" + "\n" +
                "6 - Посмотреть список ТС" + "\n" +
                "7 - Закрыть смену" + "\n" +
                "8 - Установить пробег" + "\n" +
                "9 - Заработанные средства за смену" + "\n" +
                "exit - выход");
    }

    public static void Menu(CarsCompany carsCompany) {

        printMenu();

        while (true) {
            String s = null;
            try {
                System.out.print("Введите номер команды: ");
                s = buffer.readLine();

                if (s.equals("exit"))
                    break;

                switch (s) {
                    case "1" -> {
                        carsCompany.calCostConsumption();
                    }
                    case "2" -> {
                        System.out.println("Введите код ТС:");
                        String codeCar = buffer.readLine();

                        carsCompany.SortListCarbyCodeCar(codeCar);
                    }
                    case "3" -> {
                        System.out.println("Введите смену:");
                        String nameShift = buffer.readLine();

                        fileShift = new File("sb_java/src/task01/data/shift/" + nameShift + ".txt");
                        if (fileShift.exists()) {
                            carsCompany.initCars(nameShift);
                            System.out.println("Открыта существующая смена");
                        }
                        else {
                            try {
                                fileShift.createNewFile();
                                System.out.println("Создана новая смена " + nameShift);
                            } catch (IOException e) {
                                System.out.println("Ошибка создания файла");
                                e.printStackTrace();
                            }
                        }
                    }
                    case "4" -> {
                        System.out.println("Введите код типа ТС:");
                        String codeType = buffer.readLine();

                        System.out.println("Гос номер ТС:");
                        String stateNumber = buffer.readLine();

                        System.out.println("Табельный номер:");
                        int driverPersonalNumber = Integer.parseInt(buffer.readLine());

                        carsCompany.setDriverCar(codeType, stateNumber, driverPersonalNumber);
                    }
                    case "5" -> {
                        File dir = new File("sb_java/src/task01/data/shift");
                        File[] arrFiles = dir.listFiles();

                        for (int i = 0; i < arrFiles.length; i++) {
                            System.out.println(arrFiles[i]);
                        }
                    }
                    case "6" -> {
                        carsCompany.printAllCars();
                    }
                    case "7" -> {
                        if (fileShift == null)
                            System.out.println("Смена не открыта");
                        else
                            carsCompany.updateDataFile(fileShift.getName());;
                    }
                    case "8" -> {
                        System.out.println("Введите код типа ТС:");
                        String codeType = buffer.readLine();

                        System.out.println("Гос номер ТС:");
                        String stateNumber = buffer.readLine();

                        System.out.println("Пробег:");
                        double mileage = Double.parseDouble(buffer.readLine());

                        carsCompany.setMileage(codeType, stateNumber, mileage);

                    }
                    case "9" -> {
                        carsCompany.calcEarnShift();
                    }
                }
            } catch (IOException | NumberFormatException  e) {
                System.out.println("Введены неверные данные");
            }
        }
    }


}
