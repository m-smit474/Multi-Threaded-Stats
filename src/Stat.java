import java.util.ArrayList;
import java.util.Collections;

public class Stat implements Runnable
{
	// Added some fields for a stat
	private String name;
	private Double result;
	private Double count;

	// Stat constructor
	public Stat (String name) {
		this.name = name;
		this.result = 0.0;
		this.count = 0.0;
	}


	/**
	 * Mean()
	 *
	 * Calculates the mean of a certain region.
	 *
	 * Returns the mean.
	 *
	 */
    public static double mean()
    {
        double sum = 0;
        int i;

        for (i = 0; i < Main.NUM_OF_GAMES; i++)
        {
            sum += Main.games[i].getNA_sales();

        }

        double result = sum / i;
        System.out.println("mean = " + result);

        return result;
    }

    /*
     * median
     *
     * This function calculates the median for the NA region.
     *
     * returns the NA median.
     *
     * */
    public static double median()
    {
        double med_value = 0;
        int i,size;
        int middle;

        //creates an array list of sales
        ArrayList<Double> list = new ArrayList<Double>();

        // for (i = 0; i < OpenFiles.gameNumber; i++)
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

        System.out.println("median = " + med_value);

        return med_value;
    }

    /*
     * mode
     *
     * this function calculates the mode for the NA region sales. Does not use a
     * divide and conquer method.
     *
     *Returns the calculated mode.
     */
    public static double mode()
    {
        double maxValue = 0, maxCount = 0;
        double NA_I = 0, NA_J = 0;

        for (int i = 0; i < Main.NUM_OF_GAMES; ++i)
        {
            int count = 0;
            NA_I = Main.games[i].getNA_sales();
            for (int j = 0; j < Main.NUM_OF_GAMES; ++j)
            {
                NA_J = Main.games[j].getNA_sales();
                if (NA_I == NA_J)
                    count++;
            }
            if (count > maxCount)
            {
                maxCount = count;
                maxValue = NA_I;
            }
        }

        if (maxCount == 1)
        {
            System.out.println("there is no mode for the list.");
        }
        else
        {
            System.out.println("mode = " + maxValue);
        }

        return maxValue;

    }


    /*
     * modeVersion2
     *
     * Mode that supports parallelization, uses a divide and conquer method to cut down
     * one the process time.
     *
     * Returns filled in Stat object.
     *
     */
    public static Stat modeVersion2(int start, int end)
    {
        double maxValue = 0, maxCount = 0;
        double NA_I = 0, NA_J = 0;

        Stat myStat = new Stat("mode");

        for (int i = start; i < end; ++i)
        {
            int count = 0;

            NA_I = Main.games[i].getNA_sales();
            for (int j = 0; j < Main.NUM_OF_GAMES; ++j)
            {

                NA_J = Main.games[j].getNA_sales();
                if (NA_I == NA_J)
                    count++;
            }
            if (count > maxCount)
            {
                maxCount = count;
                maxValue = NA_I;
            }
        }

        if (maxCount == 1)
        {
            System.out.println("there is no mode for the list.");
        }

        myStat.count = maxCount;
        myStat.result = maxValue;

        return myStat;

    }

    public String getName() {
		return name;
	}

	public Double getResult() {
		return result;
	}

	public Double getCount() {
		return count;
	}

	@Override
    public void run()
    {

    	if(name == "bottomMode") {
    		Stat temp = new Stat("temp");
    		temp = Stat.modeVersion2(0, (Main.NUM_OF_GAMES/2));
    		this.result = temp.result;
    		this.count = temp.count;
    	}
    	else if (name == "topMode") {
    		Stat temp = new Stat("temp");
    		temp = Stat.modeVersion2((Main.NUM_OF_GAMES/2) + 1, Main.NUM_OF_GAMES);
    		this.result = temp.result;
    		this.count = temp.count;
    	}
    	else if (name == "mean") {
    		mean();
    	}
    	else if (name == "median") {
    		median();
    	}
    	else {
    		System.out.println("Failed to run stat: " + name);
    	}

    }



}

