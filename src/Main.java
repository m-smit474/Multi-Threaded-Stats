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

        Long multithreadedDuration, sequentialDuration;

        Instant multithreadedStart = Instant.now();
        
        // Two partial modes
        Stat bottomMode = new Stat("bottomMode");
        Stat topMode = new Stat("topMode");

        Thread bottomModeThread = new Thread(bottomMode);
        Thread topModeThread = new Thread(topMode);
        Thread meanThread = new Thread(new Stat("mean"));
        Thread medianThread = new Thread(new Stat("median"));
        

        bottomModeThread.start();
        topModeThread.start();
        meanThread.start();
        medianThread.start();

        try
        {
            meanThread.join();
            medianThread.join();
            bottomModeThread.join();
            topModeThread.join();

           Instant multithreadedEnd = Instant.now();
           
           // Have two partial modes (topMode and bottomMode)
           // Final Mode calculation here:
           if(bottomMode.getResult() == topMode.getResult()) {
           	System.out.println("mode for NA_sales = " + bottomMode.getResult());
           }
           else if (bottomMode.getCount() > topMode.getCount()) {
           	System.out.println("mode for NA_sales = " + bottomMode.getResult());
           }
           else {
           	System.out.println("mode for NA_sales = " + topMode.getResult());
           }

           // Time it took for multithreaded calculations
           multithreadedDuration = Duration.between(multithreadedStart,multithreadedEnd).toMillis();
           System.out.println("Multithreaded Calculation time = " + multithreadedDuration + "ms");

        } catch (InterruptedException e)
        {
            System.out.println("Failed to join threads!");
            //e.printStackTrace();
        }



        Instant sequentialStart = Instant.now();
        Stat.mean();
        Stat.median();
        Stat.mode();
        Instant sequentialEnd = Instant.now();

        sequentialDuration = Duration.between(sequentialStart, sequentialEnd).toMillis();
        System.out.println("Sequential Calculation time = " + sequentialDuration + "ms");
        

    }

}
