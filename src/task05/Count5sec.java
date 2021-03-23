package task05;

public class Count5sec implements Runnable{

    private Message message;

    public Count5sec(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        while(true) {
            if (message.isPrintFiveSec()) {
                message.printMessage(5);
                message.setPrintFiveSec(false);
            }
        }
    }
}
