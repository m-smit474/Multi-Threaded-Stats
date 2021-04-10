import java.time.Duration;
import java.time.Instant;

public class Main {
  //-------------Constants---------------------
    public final static int NUM_OF_GAMES = 16598;
   // public final static int NUM_OF_GAMES = 40;
  //-----------Global Variables----------------
    public static Game[] games = new Game[NUM_OF_GAMES];

    public static void main(String[] args)
    {

        OpenFiles.processFile();

        Long duration,duration2;
<<<<<<< Updated upstream
        Thread modeThread,meanThread,medianThread;

        Instant start = Instant.now();


        modeThread = new Thread(() -> Stat.mode());
        meanThread = new Thread(() -> Stat.mean());
        medianThread = new Thread(() -> Stat.median());
=======
        Thread modeThread = new Thread(new Stat("mode"));
        Thread meanThread = new Thread(new Stat("mean"));
        Thread medianThread = new Thread(new Stat("median"));
        
>>>>>>> Stashed changes

        modeThread.start();
        meanThread.start();
        medianThread.start();

<<<<<<< Updated upstream
        try
        {
=======

        try
        {
            meanThread.join();
            medianThread.join();
>>>>>>> Stashed changes
            modeThread.join();
            meanThread.join(1);
            medianThread.join(1);

           Instant end = Instant.now();

           duration = Duration.between(start,end).toMillis();
           System.out.println("Thread duration = " + duration + "ms");

        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
<<<<<<< Updated upstream
=======
        
        Instant end = Instant.now();

        duration = Duration.between(start,end).toMillis();
        System.out.println("Multithreaded Calculation time = " + duration + "ms");




>>>>>>> Stashed changes

        Instant start2 = Instant.now();
        Stat.mean();
        Stat.median();
        Stat.mode();
        Instant end2 = Instant.now();

        duration2 = Duration.between(start2, end2).toMillis();
        System.out.println("Sequential Calculation time = " + duration2 + "ms");

    }

}
