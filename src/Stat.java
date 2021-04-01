import java.util.ArrayList;
import java.util.Collections;

public class Stat
{

    public static double mean()
    {
        double sum = 0;
        int i;
        for (i = 0; i < Main.NUM_OF_GAMES; i++)
        {
            sum += Main.games[i].getNA_sales();

        }
        // System.out.println(sum);

        double result = sum / i;
        System.out.println(result);
        return sum;

    }


    public static double median()
    {
        double med_value = 0;
        int i,size;
        int middle;

        //creates an array list of sales
        ArrayList<Double> list = new ArrayList<Double>();

        for(i = 0; i < Main.NUM_OF_GAMES; i++)
        {
            list.add(Main.games[i].getNA_sales());
        }

        //sorts the given list into ascending order
        Collections.sort(list);
        size = list.size();
        middle = size/2;

        if (size % 2 == 1)
        {
            med_value = list.get(middle);

        }
        else
        {
            med_value = list.get(((middle -1) + (middle)/ 2));
        }

        //System.out.println(list);
        System.out.println("median value for NA_sales = " + med_value);

        return med_value;
    }

}
