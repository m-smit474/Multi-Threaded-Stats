public class Main {
  //-------------Constants---------------------
    final static int NUM_OF_GAMES = 16000;

  //-----------Global Variables----------------
    public static Game[] games = new Game[NUM_OF_GAMES];


    public static void main(String[] args)
    {
        OpenFiles.processFile();

        for(int i = 0; i < 40; i++) {
            System.out.println(games[i]);
        }
        //File InputFile = new File(args[0]);
        //Scanner readFile = new Scanner(InputFile);
       // textProcess(readFile);

    }

}
