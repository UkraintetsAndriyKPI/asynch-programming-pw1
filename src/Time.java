public class Time implements Runnable {
    public static volatile int hourOfDay = 0;

    @Override
    public void run() {
        while(hourOfDay < 24){
            try {
                System.out.printf("\t%2d o'clock\n", hourOfDay%24);
                Thread.sleep(1000);
                hourOfDay++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("End of the day.");
    }
}
