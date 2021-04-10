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
        Thread modeThread,meanThread,medianThread;

        modeThread  = new Thread(() -> Stat.mode());
        meanThread = new Thread(() -> Stat.mean());
        medianThread = new Thread(() -> Stat.median());

        Instant start = Instant.now();

        modeThread.start();
        meanThread.start();
        medianThread.start();

        try
        {
            modeThread.join();
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try
        {
            meanThread.join();
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try
        {
            medianThread.join();
        } catch (InterruptedException e)
        {

            e.printStackTrace();
        }

        Instant end = Instant.now();

        duration = Duration.between(start,end).toMillis();
        System.out.println("Thread duration = " + duration + "ms");





        Instant start2 = Instant.now();
        Stat.mean();
        Stat.median();
        Stat.mode();
        Instant end2 = Instant.now();

        duration2 = Duration.between(start2, end2).toMillis();
        System.out.println("Thread2 = " + duration2 + "ms");

    }

}
