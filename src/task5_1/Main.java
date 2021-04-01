package task5_1;

public class Main {
    public static void main(String[] args) {

        final int countGoods = 2; // Первоначальное число товара
        final int min = 3; // Минимальное число для диапазона
        final int max = 9; // Максимальное число для диапазона

        MyMath myMath = new MyMath();

        int rnd = myMath.rnd(min, max);
        System.out.println("Количество покупателей: " + rnd);

        Warehouses warehouses = new Warehouses(countGoods);

        // создаем потоки для покупателей
        for (int i = 1; i <= rnd ; i++) {
            Thread threadBuyers = new Thread(new Buyers(warehouses, i));
            threadBuyers.setDaemon(true);
            threadBuyers.start();
        }

        // создаем поток, который будет контролировать количество поставщиков
        Thread threadControllerSuppliers = new Thread(new ControllerSuppliers(warehouses, rnd));
        threadControllerSuppliers.start();

    }


}
