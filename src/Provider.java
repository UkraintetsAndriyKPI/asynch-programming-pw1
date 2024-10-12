public class Provider implements Runnable{
    private final Thread timeThread;

    public Provider(Thread timeThread) {
        this.timeThread = timeThread;
    }

    @Override
    public void run() {
        while (timeThread.isAlive()){
            try {
                System.out.println("Provider start work.");
                Thread.sleep(30);
                while(timeThread.isAlive()){

                    Main.placesFree.acquire();
                    Main.placesUsed.release();
                    System.out.println("Provider delivered new package.");
                    Thread.sleep(2000);
                }
                System.out.println("Provider end work.");
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
