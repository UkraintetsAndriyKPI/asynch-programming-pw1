public class Buyer implements Runnable {
    private final Thread timeThread;

    public Buyer(Thread timeThread) {
        this.timeThread = timeThread;
    }

    @Override
    public void run() {
        try {
            while(timeThread.isAlive())
                if(Time.hourOfDay > 7) break;
            System.out.println("Buyer start working.");
            Thread.sleep(30);
            while(Time.hourOfDay < 18){
                Main.placesUsed.acquire();
                Main.placesFree.release();
                Thread.sleep(250);
                System.err.println("Buyer bought a package.");
            }
            System.out.println("Buyer end the work.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
