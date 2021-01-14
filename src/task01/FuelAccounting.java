package task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FuelAccounting {

// расход
    public static double getConsumption(String code){
        if (code.equals("100"))
            return 12.5;
        else if (code.equals("200"))
            return 12;
        else if (code.equals("300"))
            return 11.5;
        else if (code.equals("400"))
            return 20;
        else
            return 1;
    }
// стоимость литра
    public static double getPrice(String code){
        if (code.equals("100"))
            return 46.10;
        else if (code.equals("300"))
            return 47.50;
        else if (code.equals("200") || code.equals("400"))
            return 48.90;
        else
            return 1;
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
        double[] CastCons = new double[4]; // данные по затратам в разрезе типа ТС

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
                
                if (codeCar.equals("100")){
                    CastCons[0] += CostConsumption;
                }
                else if (codeCar.equals("200")) {
                    CastCons[1] += CostConsumption;
                }
                else if (codeCar.equals("300")) {
                    CastCons[2] += CostConsumption;
                }
                else if (codeCar.equals("400")) {
                    CastCons[3] += CostConsumption;
                }

                idxArray += 1;
            }

        }

        // общая стоимость + расход по каждому типу ТС
        for (int i = 0; i < CastCons.length; i++) {
            String codeT = i+1+"00";
            System.out.println("Расход для "+ codeT +" типа ТС "+ CastCons[i]);
            allCostConsumption += CastCons[i];

            if (i == 0) {
                valMaxCost = CastCons[i];
                valMinCost = CastCons[i];
                codeMaxCost = codeT;
                codeMinCost = codeT;
            }
            else {
                if (CastCons[i] > valMaxCost) {
                    valMaxCost = CastCons[i];
                    codeMaxCost = codeT;
                }
                if (CastCons[i] < valMinCost) {
                    valMinCost = CastCons[i];
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
                    String dummy[] = twoDimData[in];
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
                for (int i = 0; i < twoDimData.length; i++) {
                    if (twoDimData[i][0].equals(s) || s.equals("all")){
                        String val;
                        val = "C" + twoDimData[i][0] + "_" + twoDimData[i][1] + "-" + twoDimData[i][2];
                        if (twoDimData[i][3] != null)
                            val = val +  "-" + twoDimData[i][3];

                        System.out.println(val);
                    }
                }
            }
            else
                System.out.println("Данного типа ТС не существует!!!");
        }

    }
}
