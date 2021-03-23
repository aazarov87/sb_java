package task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Старая реализация. Новая в NewFuelAccounting
 */
public class FuelAccounting {

// расход
    public static double getConsumption(String code){
        return switch (code) {
            case "100" -> 12.5;
            case "200" -> 12;
            case "300" -> 11.5;
            case "400" -> 20;
            default -> 1;
        };
    }
// стоимость литра
    public static double getPrice(String code){
        return switch (code) {
            case "100" -> 46.10;
            case "300" -> 47.50;
            case "200", "400" -> 48.90;
            default -> 1;
        };
    }

    public static void main(String[] args) throws IOException {

        double allCostConsumption = 0;
        double CostConsumption;
        int idxArray = 0;

        String codeMaxCost = null;
        String codeMinCost = null;
        double valMaxCost = 0;
        double valMinCost = 0;

        //C(CODE_CAR)_гос номер-Пробег-(доп. параметр)
        String[] InData  = new String[] {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
        String[][] twoDimData = new String[InData.length][5]; // массив данных в разрезе каждого ТС
        double[] CostCons = new double[4]; // данные по затратам в разрезе типа ТС

        for (String data : InData) {
            int idx;
            int idxParam;

            idx = data.indexOf("-");
            if (idx > -1) {
                String codeCar;

                codeCar = data.substring(1, 4);
                twoDimData[idxArray][0] = codeCar; // код типа ТС
                twoDimData[idxArray][1] = data.substring(5, idx); // номер

                idxParam = data.indexOf("-", idx + 1);

                // пробег
                if (idxParam > -1) {

                    twoDimData[idxArray][2] = data.substring(idx + 1, data.indexOf("-", idx + 1)); //пробег
                    twoDimData[idxArray][3] = data.substring(idxParam + 1); // доп параметр

                } else {
                    twoDimData[idxArray][2] = data.substring(idx + 1);
                }

                CostConsumption = Integer.parseInt(twoDimData[idxArray][2]) * getConsumption(codeCar) / 100 * getPrice(codeCar);

                switch (codeCar) {
                    case "100" -> CostCons[0] += CostConsumption;
                    case "200" -> CostCons[1] += CostConsumption;
                    case "300" -> CostCons[2] += CostConsumption;
                    case "400" -> CostCons[3] += CostConsumption;
                }

                idxArray += 1;
            }

        }

        // общая стоимость + расход по каждому типу ТС
        for (int i = 0; i < CostCons.length; i++) {
            String codeT = i+1+"00";
            System.out.println("Расход для "+ codeT +" типа ТС "+ CostCons[i]);
            allCostConsumption += CostCons[i];

            if (i == 0) {
                valMaxCost = CostCons[i];
                valMinCost = CostCons[i];
                codeMaxCost = codeT;
                codeMinCost = codeT;
            }
            else {
                if (CostCons[i] > valMaxCost) {
                    valMaxCost = CostCons[i];
                    codeMaxCost = codeT;
                }
                if (CostCons[i] < valMinCost) {
                    valMinCost = CostCons[i];
                    codeMinCost = codeT;
                }
            }
        }

        System.out.println("Общая стоимость расходов "+ allCostConsumption);
        System.out.println("Наибольший расход у ТС типа "+ codeMaxCost);
        System.out.println("Наименьший расход у ТС типа "+ codeMinCost);

        System.out.println("----------------------");

        // sort
        for (int out = twoDimData.length-1; out >= 0; out--){
            for (int in = 0; in < out; in++){
                if (
                        (Integer.parseInt(twoDimData[in][2]) > Integer.parseInt(twoDimData[in + 1][2]))
                        || ((Integer.parseInt(twoDimData[in][2]) == Integer.parseInt(twoDimData[in + 1][2]))
                                && ((twoDimData[in + 1][3] == null ) || (twoDimData[in + 1][3] != null && twoDimData[in][3] != null && Integer.parseInt(twoDimData[in][3]) > Integer.parseInt(twoDimData[in + 1][3]))
                        )
                        )
                )
                {
                    String[] dummy = twoDimData[in];
                    twoDimData[in]= twoDimData[in+1];
                    twoDimData[in+1] = dummy;
                }
            }
        }

        // вывод данных по запросу
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            System.out.println("Введите код типа ТС. all - весь список. exit - выход");
            String s = buffer.readLine();

            if (s.equals("exit"))
                break;

            if (s.equals("100") || s.equals("200") || s.equals("300") || s.equals("400") || s.equals("all")) {
                for (String[] twoDimDatum : twoDimData) {
                    if (twoDimDatum[0].equals(s) || s.equals("all")) {
                        String val;
                        val = "C" + twoDimDatum[0] + "_" + twoDimDatum[1] + "-" + twoDimDatum[2];
                        if (twoDimDatum[3] != null)
                            val = val + "-" + twoDimDatum[3];

                        System.out.println(val);
                    }
                }
            }
            else
                System.out.println("Данного типа ТС не существует!!!");
        }

    }
}
