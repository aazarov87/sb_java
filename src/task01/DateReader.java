package task01;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

/*
Класс чтения или ввода данных с клавиатуры по ТС в формате:
C(CODE_CAR)_гос номер-Пробег-(доп. параметр)
 */
public class DateReader {

    //карта типов ТС
    public HashMap<String, CarType> carsTypeList;

    //файл для чтения данных
    private static final String fileCarType = "sb_java/src/task01/data/darCars.txt";

    public static ArrayList getDataCar() {
        ArrayList dataCar = new ArrayList();
        CarType carType;

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ручной ввод - 1. Чтение из файла - 2. Выход - exit");
        String s = null;
        try {
            s = buffer.readLine();

            switch (s) {
                case "1" -> {
                    String str = buffer.readLine();
                    System.out.println("Ведите значение(C(CODE_CAR)_гос номер-Пробег-(доп. параметр)). Выход - exit");
                    while (true) {
                        if (str.equals("exit"))
                            break;

                        dataCar.add(str);
                    }
                }
                case "2" -> {
                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(fileCarType), StandardCharsets.UTF_8))) {
                        String line;

                        while ((line = reader.readLine()) != null) {
                            //System.out.println("line = " + line);
                            dataCar.add(line);
                        }
                    }

                    catch(IOException e){
                    System.out.println(e.getMessage());
                }

                    /*dataCar = new ArrayList(Arrays.asList("C100_1-100"
                                                        , "C200_1-120-1200"
                                                        , "C300_1-120-30"
                                                        , "C400_1-80-20"
                                                        , "C100_2-50"
                                                        , "C200_2-40-1000"
                                                        , "C300_2-200-45"
                                                        , "C400_2-10-20"
                                                        , "C100_3-10"
                                                        , "C200_3-170-1100"
                                                        , "C300_3-120-29"
                                                        , "C400_3-100-28"
                                                        , "C100_1-300"
                                                        , "C200_1-100-750"
                                                        , "C300_1-32-15")
                                                );*/
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataCar;
    }

}
