package task01;

import java.io.*;

/*
Класс водитель
 */
public class DriverCompany implements Externalizable {

    private static final long serialVersionUID = -7054622821690949724L;

    private String firstName;
    private String lastName;
    private int age;
    private int personalNumber;

    public DriverCompany(String firstName, String lastName, int age, int personalNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.personalNumber = personalNumber;
    }

    public DriverCompany(){

    };

    public String getFirstName() {
        return firstName;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String printFirstLastName(){
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "DriverCompany{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", personalNumber=" + personalNumber +
                '}';
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getFirstName());
        out.writeObject(this.getLastName());
        out.writeObject(this.getAge());
        out.writeObject(this.getPersonalNumber());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setFirstName((String) in.readObject());
        setLastName((String) in.readObject());
        setAge((int) in.readObject());
        setPersonalNumber((int) in.readObject());
    }
}
