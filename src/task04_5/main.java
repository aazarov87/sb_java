package task04_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class main {

    // функция возвращает имя победителя
    public static String getNamWinner(ArrayList<String> arrPlayers) {
        // имя победителя и макс количество очков
        String nameWinner = null;
        Integer maxPoints = 0;

        // мапа для хранение суммы очков игрока
        HashMap<String, Integer> listPlayers = new HashMap<>();

        // индекс для определения положения пробела
        int idx;

        for (int i = 0; i < arrPlayers.size(); i++) {
            idx = arrPlayers.get(i).indexOf(" ");

            if (idx > -1) {
                Integer pointsSumForPlayer;
                Integer pointsForPlayer;
                String namePlayer;

                // читаем из строки имя и количество очков
                pointsForPlayer = Integer.parseInt(arrPlayers.get(i).substring(idx+1));
                namePlayer =  arrPlayers.get(i).substring(0, idx);

                //заносим в мапу суммируя очки
                if (listPlayers.containsKey(namePlayer))
                    pointsSumForPlayer =  listPlayers.getOrDefault(namePlayer, 0) + pointsForPlayer;
                else
                    pointsSumForPlayer = pointsForPlayer;

                listPlayers.put(namePlayer, pointsSumForPlayer);

                // макс количество очков из всех игроков и его имя
                if (maxPoints < pointsSumForPlayer){
                    maxPoints = pointsSumForPlayer;
                    nameWinner = namePlayer;
                }
            }
        }

        System.out.println("--------- maxPoints = " + maxPoints + " ---------");
        return nameWinner;
    }

    public static void main(String[] args) {
        ArrayList<String> arrPlayers = new ArrayList<String>(Arrays.asList(new String[]{"Ivan 5"
                                                                                        , "Petr 3"
                                                                                        , "Alex 10"
                                                                                        , "Petr 8"
                                                                                        , "Ivan 6"
                                                                                        , "Alex 5"
                                                                                        , "Ivan 1"
                                                                                        , "Alex 1"
                                                                                        , "Petr 5"}));

        /*arrPlayers.add("Ivan 5");
        arrPlayers.add("Petr 3");
        arrPlayers.add("Alex 10");
        arrPlayers.add("Petr 8");
        arrPlayers.add("Ivan 6");
        arrPlayers.add("Alex 5");
        arrPlayers.add("Ivan 1");
        arrPlayers.add("Alex 1");
        arrPlayers.add("Petr 5");*/

        System.out.println(getNamWinner(arrPlayers));
    }
}
