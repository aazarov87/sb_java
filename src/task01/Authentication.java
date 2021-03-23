package task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Класс аутентификации пользователя
 */
public class Authentication {

    private BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    //пользователь, который прошел аутентификацию
    private User userAuth;

    public User getUserAuth(){
        return userAuth;
    }

    // ввод логина
    private String getLogin() {
        System.out.print("login: ");
        String login = null;
        try {
            login = buffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return login;
    }

    //ввод пароля
    private String getPassword() {
        System.out.print("password: ");
        String password = null;
        try {
            password = buffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return password;
    }


    public void putData() {
        ArrayList<User> users;
        Boolean isAuth = false;

        users = ListUsers.getListUser();

        // пока введенные данные не совпадут делаем цикл
        while (!isAuth) {
            String login = getLogin();
            String password = getPassword();

            for (User user1 : users
            ) {
                if ((user1.getLogin().equals(login) && (user1.getPassword().equals(password)))) {
                    userAuth = user1;
                    //System.out.println("true");
                    isAuth = true;
                }
            }

            if (!isAuth)
                System.out.println("Неверный логин/пароль");
        }
    }
}

