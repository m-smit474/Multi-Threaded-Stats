import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpenFiles
{
    //-------------Constants---------------------
	final static byte NUM_OF_FIELDS = 11;

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
        String rank, name, platform, year, genre, publisher;
        Double na_sales, eu_sales, jp_sales, other_sales, global_sales;

        try {
            Scanner file = new Scanner(new File(fileName));

            file.nextLine(); // Don't want to process first line because it's the categories

            int gameNumber = 0;
            while(file.hasNextLine() && gameNumber < Main.NUM_OF_GAMES) {
                // Goes through each line.
                // Lines are of the form:
        // Rank, Name, Platform, Year, Genre, Publisher, NA_Sales, EU_Sales, JP_Sales, Other_sales, Global_sales

                String line = file.nextLine();
                String[] tokens = line.split(",");

                // Handles case where names include commas
                // Names with commas will have more tokens
                int extraParts = tokens.length - NUM_OF_FIELDS;

                // Extract fields from line
                rank = tokens[RANK];
                name = tokens[NAME];

                // Add extra parts of name (in case commas are in name)
                for(int i = 0; i < extraParts; i++) {
                	name = name + tokens[NAME + (i+1)];
                }

                platform = tokens[PLATFORM + extraParts];
                year = tokens[YEAR + extraParts];
                genre = tokens[GENRE + extraParts];
                publisher = tokens[PUBLISHER + extraParts];
                na_sales = Double.parseDouble(tokens[NA_SALES + extraParts]);
                eu_sales = Double.parseDouble(tokens[EU_SALES + extraParts]);
                jp_sales = Double.parseDouble(tokens[JP_SALES + extraParts]);
                other_sales = Double.parseDouble(tokens[OTHER_SALES + extraParts]);
                global_sales = Double.parseDouble(tokens[GLOBAL_SALES + extraParts]);

                // Create new game object with corresponding fields
                Game newGame = new Game(rank, name, platform, year, genre, publisher, na_sales,
                        eu_sales, jp_sales, other_sales, global_sales);

                // Add game to global structure
                Main.games[gameNumber] = newGame;

                gameNumber++;
            }

            file.close();

        } catch(FileNotFoundException ex) {
            System.out.println("Could not find file: " + fileName);
        }

    }
}