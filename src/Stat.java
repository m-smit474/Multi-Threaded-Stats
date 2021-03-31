
public class Stat {

    public static double mean() {
        double sum = 0;
        int i;
        for (i = 0; i < Main.NUM_OF_GAMES; i++) {
            sum += Main.games[i].getNA_sales();

        }
       // System.out.println(sum);

       double result = sum / i;
       System.out.println(result);
        return sum;

    }

}
