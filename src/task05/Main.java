package task05;

public class Main {

    public static void main(String[] args) {

        Message message = new Message();

        // создаем поток, который будет каждую секунду отправлять сообщение
        // поток демон, чтобы завершился, когда завершится основной поток
        Thread thread1Sec  = new Thread(new Count1sec(message));
        thread1Sec.setDaemon(true);
        thread1Sec.start();

        // создаем поток, который будет каждые 5 секунду отправлять сообщение
        // поток демон, чтобы завершился, когда завершится основной поток
        Thread thread5Sec = new Thread(new Count5sec(message));
        thread5Sec.setDaemon(true);
        thread5Sec.start();

        // основной поток - таймер
        Thread threadTimer = new Thread(new Timer(message));
        threadTimer.start();
    }
}
