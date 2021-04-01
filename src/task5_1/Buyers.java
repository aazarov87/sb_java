package task5_1;

//покупатели
public class Buyers implements Runnable {
    private Warehouses warehouses;
    private int numberBuyer;

    public Buyers(Warehouses warehouses, int numberBuyers) {
        this.warehouses = warehouses;
        this.numberBuyer = numberBuyers;
    }

    @Override
    public void run() {
        System.out.println("start Buyers " + this.numberBuyer);

        while(true) {
            // забираем каждую секунду товар со склада
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            warehouses.reduceQuantityGoods();
        }
    }
}
