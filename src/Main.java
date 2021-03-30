public class Main {
  //-------------Constants---------------------
    public final static int NUM_OF_GAMES = 16598;

  //-----------Global Variables----------------
    public static Game[] games = new Game[NUM_OF_GAMES];


    public static void main(String[] args)
    {
        OpenFiles.processFile();

        for(int i = 0; i < NUM_OF_GAMES; i++) {
            System.out.println(games[i]);
        }
        //File InputFile = new File(args[0]);
        //Scanner readFile = new Scanner(InputFile);
       // textProcess(readFile);

    }

}
