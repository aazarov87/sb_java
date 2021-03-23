package task01;

import java.io.*;

/*
Меню администратора
 */
public class MenuAdmin {
    private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    private static void printMenuAdmin(){
        System.out.println("Введите номер команды: " + "\n" +
                "1 - Добавить пользователя" + "\n" +
                "2 - Удалить пользователя" + "\n" +
                "3 - Список всех пользователе" + "\n" +
                "4 - Добавить водителя" + "\n" +
                "5 - Удалить водителя" + "\n" +
                "6 - Список всех водителей" + "\n" +
                "7 - Добавить ТС" + "\n" +
                "8 - Удалить ТС" + "\n" +
                "9 - Список всех ТС" + "\n" +
                "exit - выход");
    }

    public static void MenuAdmin() {

        printMenuAdmin();

        while (true) {
            String s = null;
            try {
                s = buffer.readLine();

                if (s.equals("exit"))
                    break;

                switch (s) {
                    case "1" -> {
                        System.out.print("Фамилия: ");
                        String firstName = buffer.readLine();

                        System.out.print("Имя: ");
                        String lastName = buffer.readLine();

                        System.out.print("Логин: ");
                        String login = buffer.readLine();

                        System.out.print("Пароль: ");
                        String password = buffer.readLine();

                        System.out.print("Админ(да/нет): ");
                        String val = buffer.readLine();

                        boolean isAdminRole;
                        if (val.equals("да"))
                            isAdminRole = true;
                        else
                            isAdminRole = false;

                        ListUsers.addUser(firstName, lastName, login, password, isAdminRole);
                    }
                    case "2" -> {
                        System.out.print("Логин: ");
                        String login = buffer.readLine();
                        ListUsers.delUser(login);
                    }
                    case "3" -> {
                        ListUsers.printUser();
                    }
                    case "4" -> {
                        System.out.print("Фамилия: ");
                        String firstName = buffer.readLine();

                        System.out.print("Имя: ");
                        String lastName = buffer.readLine();

                        System.out.print("Возраст: ");
                        int age = Integer.parseInt(buffer.readLine());

                        System.out.print("Табельный: ");
                        int personalNumber = Integer.parseInt(buffer.readLine());

                        ListDrivers.addDriverCompany(firstName, lastName, age, personalNumber);
                    }
                    case "5" -> {
                        System.out.print("Табельный: ");
                        int personalNumber = Integer.parseInt(buffer.readLine());
                        ListDrivers.delDriverCompany(personalNumber);
                    }
                    case "6" -> {
                        ListDrivers.printDriversCompany();
                    }
                    case "7" -> {
                        System.out.print("Код ТС: ");
                        String code = buffer.readLine();

                        System.out.print("Наименование ТС: ");
                        String name = buffer.readLine();

                        System.out.print("Расход: ");
                        double сonsumption = Double.valueOf(buffer.readLine());

                        System.out.print("Цена за литр: ");
                        double priceLiterFuel = Double.valueOf(buffer.readLine());

                        ListCarType.addCarType(code, name, сonsumption, priceLiterFuel);
                    }
                    case "8" -> {
                        System.out.print("Код ТС: ");
                        String code = buffer.readLine();

                        ListCarType.delCarType(code);
                    }
                    case "9" ->
                        ListCarType.printCarType();
                }
            } catch (IOException e) {
                System.out.println("Введите корректное значение");
                e.printStackTrace();
            }
        }
    }

}
