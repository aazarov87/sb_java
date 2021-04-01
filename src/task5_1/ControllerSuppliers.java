package task5_1;

import java.util.ArrayList;
import java.util.List;

public class ControllerSuppliers implements Runnable {

    private Warehouses warehouses;
    private int quantityByuers;

    public ControllerSuppliers(Warehouses warehouses, int quantityByuers) {
        this.warehouses = warehouses;
        this.quantityByuers = quantityByuers;
    }

    @Override
    public void run() {
        System.out.println("start ControllerSuppliers");

        // сколько секунд работаем
        int cnt = 0;
        List<Thread> listSupplers = new ArrayList<Thread>();

        while (cnt < 30) {
            //если количества товара на складе меньше чем покупателей, добавляем поставщика
            if ((warehouses.getQuantityGoods() - quantityByuers) <= 0) {
                Thread thread = new Thread(new Suppliers(warehouses, listSupplers.size() + 1));
                thread.setDaemon(true);
                thread.start();
                listSupplers.add(thread);
                System.out.println("Добавили поставщика, всего " + listSupplers.size());
            }

            //если количества товара на складе больше чем количестов покупателей+3(magic number))), добавляем поставщика
            if ((warehouses.getQuantityGoods()) > quantityByuers + 3)
            {
                // Если есть поставщики, останавливаем 1 поток
                if (listSupplers.size() > 0) {
                    listSupplers.get(0).stop();
                    System.out.println("Удалили 1 поставщика,"+ listSupplers.get(0).getName() +" всего " + listSupplers.size());
                    listSupplers.remove(0);
                }
            }

            // делаем проверку контроллером каждые 0,5 сек
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cnt +=1;
        }
    }
}
