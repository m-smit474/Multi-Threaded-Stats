import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpenFiles
{
    //-------------Constants---------------------

    // Offsets for different fields within a line
    final static byte RANK = 0;
    final static byte NAME = 1;
    final static byte PLATFORM = 2;
    final static byte YEAR = 3;
    final static byte GENRE = 4;
    final static byte PUBLISHER = 5;
    final static byte NA_SALES = 6;
    final static byte EU_SALES = 7;
    final static byte JP_SALES = 8;
    final static byte OTHER_SALES = 9;
    final static byte GLOBAL_SALES = 10;

    public static void processFile() {
        String fileName = "vgsales.csv";
        //Game[] games = new Game[NUM_OF_GAMES];
        String rank, name, platform, year, genre, publisher, na_sales, eu_sales,
        jp_sales, other_sales, global_sales;

        try {
            Scanner file = new Scanner(new File(fileName));

            file.nextLine(); // Don't want to process first line

            int gameNumber = 0;
            while(file.hasNextLine() && gameNumber < Main.NUM_OF_GAMES) {
                // Goes through each line.
                // Lines are of the form:
        // Rank, Name, Platform, Year, Genre, Publisher, NA_Sales, EU_Sales, JP_Sales, Other_sales, Global_sales

                String line = file.nextLine();
                String[] tokens = line.split(",");
                rank = tokens[RANK];
                name = tokens[NAME];
                platform = tokens[PLATFORM];
                year = tokens[YEAR];
                genre = tokens[GENRE];
                publisher = tokens[PUBLISHER];
                na_sales = tokens[NA_SALES];
                eu_sales = tokens[EU_SALES];
                jp_sales = tokens[JP_SALES];
                other_sales = tokens[OTHER_SALES];
                global_sales = tokens[GLOBAL_SALES];

                Game newGame = new Game(rank, name, platform, year, genre, publisher, na_sales,
                        eu_sales, jp_sales, other_sales, global_sales);

                Main.games[gameNumber] = newGame;

                //System.out.println(newGame);
                //System.out.println("Line " + gameNumber + " name is: " + tokens[NAME]);

                gameNumber++;
            }

            file.close();

        } catch(FileNotFoundException ex) {
            System.out.println("Could not find file: " + fileName);
        }

    }
}