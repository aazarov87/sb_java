package task05;

public class Timer implements Runnable{

    private Message message;

    public Timer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20 ; i++) {
            message.setPrintOneSec(true);

            if (i % 5 == 0) {
                message.setPrintFiveSec(true);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
