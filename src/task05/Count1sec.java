package task05;

public class Count1sec implements Runnable {

    private Message message;

    public Count1sec(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        while(true) {
            if (message.isPrintOneSec()) {
                message.printMessage(1);
                message.setPrintOneSec(false);
            }
        }
    }
}
