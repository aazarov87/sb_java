package task01;

import java.io.*;
import java.util.ArrayList;
/*
Пользователи системы
 */
public class ListUsers {

    public static ArrayList<User> users = new ArrayList<User>();

    public static void initListUser(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("sb_java/src/task01/data/users.txt"))) {
            users = (ArrayList<User>) in.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            users.add(new User("Admin", "Admin", "Admin", "passAdmin", true));
            updateDataFile();
        }
    }

    public static ArrayList<User> getListUser(){
        if (users.size() == 0){
            initListUser();
        }

        return users;
    }

    public static void printUser(){
        if (users.size() == 0){
            initListUser();
        }

        for (User user1 : users
        ) {
            System.out.println(user1);
        }
    }

    public static void addUser(String firstName, String lastName, String login, String password, boolean isAdminRole){
        boolean isUserExists = false;

        for (User user: users
             ) {
           if (user.getLogin().equals(login)) {
               System.out.println("Пользователь с логином = " + login + " уже существует");
               isUserExists = true;
           }
        }

        if (!isUserExists) {
            users.add(new User(firstName, lastName, login, password, isAdminRole));
            updateDataFile();
        }
    }

    private static void updateDataFile(){
        try (FileOutputStream fileOutputStream = new FileOutputStream("sb_java/src/task01/data/users.txt")){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delUser(String login){
        int idx = -1;
        for (int i = 0; i < users.size() ; i++) {
            if (users.get(i).getLogin().equals(login)) {
                idx = i;
            }
        }

        if (idx > -1) {
            users.remove(idx);
            updateDataFile();
        }
        else
            System.out.println("Пользователь с логином " + login + " не существует");


    }
}
