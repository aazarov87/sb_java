package task05;

import java.sql.SQLOutput;

public class Message {

    private boolean printOneSec;
    private boolean printFiveSec;

    public void Message(){
        printFiveSec = false;
        printOneSec = false;
    }

    public synchronized boolean isPrintOneSec() {
        return printOneSec;
    }

    public synchronized void setPrintOneSec(boolean printOneSec) {
        this.printOneSec = printOneSec;
    }

    public synchronized boolean isPrintFiveSec() {
        return printFiveSec;
    }

    public synchronized void setPrintFiveSec(boolean printFiveSec) {
        this.printFiveSec = printFiveSec;
    }

    public void printMessage(int valSec){
        System.out.println("count " + valSec + " sec");
    }

}
