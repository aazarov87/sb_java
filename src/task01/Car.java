package task01;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car implements Externalizable {

    // Код ТС
    private CarType carType;

    // гос номер
    private String stateNumber;

    //Пробег
    private double mileage;

    //доп параметры
    private String addParam;

    //назначенный водитель
    private DriverCompany driverCompany;

    public DriverCompany getDriverCompany() {
        return driverCompany;
    }

    public void setDriverCompany(DriverCompany driverCompany) {
        this.driverCompany = driverCompany;
    }

    public Car(CarType carType
               , String stateNumber
               , int mileage
               , String addParam){
        this.carType = carType;
        this.stateNumber = stateNumber;
        this.mileage = mileage;
        this.addParam = addParam;
    }

    public Car(){};

    @Override
    public String toString() {
        String str = this.getCarType().getCode()
                + ": " + this.getCarType().getName()
                + " гос.номер = " + this.getStateNumber()
                + " пробег = " + this.getMileage();

        if (this.getAddParam() != null)
            str = str + "  доп параметры = " + this.getAddParam();

        if (this.getDriverCompany() != null)
            str = str + "  водитель = " + this.getDriverCompany().getFirstName() + " " + this.getDriverCompany().getLastName() + " " + this.getDriverCompany().getPersonalNumber();

        return str;
    }

    public void setAddParam(String addParam) {
        this.addParam = addParam;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getAddParam() {
        return addParam;
    }

    public double getMileage() {
        return mileage;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public CarType getCarType() {
        return carType;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //System.out.println("writeExternal Car");
        out.writeObject(this.getCarType());
        out.writeObject(this.getDriverCompany());
        out.writeObject(this.getAddParam());
        out.writeObject(this.getMileage());
        out.writeObject(this.getStateNumber());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
       // System.out.println("readExternal Car");
        setCarType((CarType) in.readObject());
        setDriverCompany((DriverCompany)in.readObject());
        setAddParam((String) in.readObject());
        setMileage((Double)in.readObject());
        setStateNumber((String) in.readObject());
    }
}