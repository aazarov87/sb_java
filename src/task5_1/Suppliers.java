package task5_1;

//поставщики
public class Suppliers implements Runnable{
    private Warehouses warehouses;
    private int numberSupplier;

    public Suppliers(Warehouses warehouses, int numberSupplier) {
        this.warehouses = warehouses;
        this.numberSupplier = numberSupplier;
    }

    @Override
    public void run() {
        System.out.println("start Suppliers = " + this.numberSupplier);
        while(true) {
            // добавляем каждую секунду товар на склад
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            MyMath myMath = new MyMath();
            // добаляем random 1-2 товара
            warehouses.incQuantityGoods(myMath.rnd(1, 2));
        }
    }
}
