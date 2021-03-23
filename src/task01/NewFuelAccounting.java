package task01;

import java.util.ArrayList;

public class NewFuelAccounting {

    public static void main(String[] args) {
        ArrayList<String> dataCar;

        Authentication authentication = new Authentication();
        authentication.putData();

        if (authentication.getUserAuth() != null) {
            if (authentication.getUserAuth().isAdminRole())
                // меню администратора
                MenuAdmin.MenuAdmin();
            else {
                dataCar = DateReader.getDataCar();
                ListCarType.initCarTypeFromFile();
                ListDrivers.initListDriversCompany();

                CarsCompany carsCompany = new CarsCompany();
                for (String str : dataCar
                ) {
                    carsCompany.initCarsList(str);
                }

                //меню пользователя
                MenuUser.Menu(carsCompany);
            }

        }

    }
}
