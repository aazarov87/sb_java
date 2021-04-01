package task5_1;

public class Warehouses {

    private int quantityGoods;

    public synchronized int getQuantityGoods() {
        return quantityGoods;
    }

    public synchronized void setQuantityGoods(int quantityGoods) {
        this.quantityGoods = quantityGoods;
    }

    public Warehouses(int quantityGoods) {
        this.quantityGoods = quantityGoods;
    }

    public synchronized void reduceQuantityGoods(){
        if (quantityGoods >= 1) {
            quantityGoods -= 1;
            System.out.println("Забрали товар, осталось на складе  " + getQuantityGoods());
        }else
            System.out.println("Не забрали т.к. склад пустой товаров = " + quantityGoods);
    }

    public synchronized void incQuantityGoods(int count){
        quantityGoods += count;
        System.out.println("Добавили товаров "+ count +", осталось на складе " + getQuantityGoods());
    }
}
