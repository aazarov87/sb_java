package task04_2;

import java.util.HashMap;

public class alphabet {

    public static void calcCharacter(String str){
        HashMap<Character, Integer> mapChar = new HashMap<>();

        for (int i = 0; i < str.length(); i++)
        {
            // читаем символ
            char ch  = str.charAt(i);

            // если считанный символ лежит в диапазане англ алфавита, проверяем естьли он в map
            // если есть, то увеличиваем значение на 1
            if ((int)str.charAt(i) >= (int)'a' && (int)str.charAt(i) <= (int)'z')
                    mapChar.put(ch, mapChar.getOrDefault(ch, 0) + 1);
        }

        //выводим результат
        for (HashMap.Entry<Character,Integer> pair:mapChar.entrySet())
            System.out.println(pair.getKey() + " = " + pair.getValue());

    }
}
