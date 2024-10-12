import java.util.concurrent.Semaphore;

public class Main {
    public static final Semaphore placesFree = new Semaphore(3);
    public static final Semaphore placesUsed = new Semaphore(0);
    public static void main(String[] args) throws InterruptedException {
        Runnable storage = () -> {
            Thread timeThread = new Thread(new Time(), "timeThread");
            timeThread.start();
            Thread provider = new Thread(new Provider(timeThread), "providerThread");
            provider.start();
            Thread buyer = new Thread(new Buyer(timeThread), "buyerThread");
            buyer.start();

        };
        Thread storageT = new Thread(storage);
        storageT.start();
        storageT.join();
    }
}