package task04_5;

import java.util.ArrayList;
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
        ArrayList<String> arrPlayers = new ArrayList<>();

        arrPlayers.add("Ivan 5");
        arrPlayers.add("Petr 3");
        arrPlayers.add("Alex 6");
        arrPlayers.add("Petr 7");
        arrPlayers.add("Ivan 2");
        arrPlayers.add("Alex 7");
        arrPlayers.add("Ivan 8");
        arrPlayers.add("Petr 7");
        arrPlayers.add("Alex 3");

        System.out.println(getNamWinner(arrPlayers));
    }
}
