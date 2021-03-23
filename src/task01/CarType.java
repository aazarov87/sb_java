package task01;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/*
Класс типов ТС
 */
public class CarType implements Externalizable {
    private static final long serialVersionUID = -5661383729303908108L;

    // Код ТС
    private String code;

    //Наименование ТС
    private String name;

    // расход
    private double сonsumption;

    // цена литра
    private double priceLiterFuel;

    public CarType(String code, String name, double сonsumption, double priceLiterFuel) {
        this.code = code;
        this.name = name;
        this.сonsumption = сonsumption;
        this.priceLiterFuel = priceLiterFuel;
    }

    public CarType() {

    }

    @Override
    public String toString() {
        return "CarType{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", сonsumption=" + сonsumption +
                ", priceLiterFuel=" + priceLiterFuel +
                '}';
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getСonsumption() {
        return сonsumption;
    }

    public void setСonsumption(double сonsumption) {
        this.сonsumption = сonsumption;
    }

    public double getPriceLiterFuel() {
        return priceLiterFuel;
    }

    public void setPriceLiterFuel(double priceLiterFuel) {
        this.priceLiterFuel = priceLiterFuel;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getCode());
        out.writeObject(this.getName());
        out.writeObject(this.getPriceLiterFuel());
        out.writeObject(this.getСonsumption());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setCode((String) in.readObject());
        setName((String) in.readObject());
        setPriceLiterFuel((Double) in.readObject());
        setСonsumption((Double) in.readObject());
    }
}
