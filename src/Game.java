
public class Game {
    private String rank;
    private String name;
    private String platform;
    private String year;
    private String genre;
    private String publisher;
    private String NA_sales;
    private String EU_sales;
    private String JP_sales;
    private String other_sales;
    private String global_sales;

    public Game(String myRank, String myName, String myPlatform, String myYear, String myGenre, String myPublisher,
            String na_sales, String eu_sales, String jp_sales, String other, String global) {
     rank = myRank;
     name = myName;
     platform = myPlatform;
     year = myYear;
     genre = myGenre;
     publisher = myPublisher;
     NA_sales = na_sales;
     EU_sales = eu_sales;
     JP_sales = jp_sales;
     other_sales = other;
     global_sales = global;
    }

@Override
    public String toString() {
        return "Game [rank=" + rank + ", name=" + name + ", platform=" + platform + ", year=" + year + ", genre="
                + genre + ", publisher=" + publisher + ", NA_sales=" + NA_sales + ", EU_sales=" + EU_sales
                + ", JP_sales=" + JP_sales + ", other_sales=" + other_sales + ", global_sales=" + global_sales + "]";
    }

public String getName() {
    return name;
}
public String getPlatform() {
    return platform;
}
public String getYear() {
    return year;
}
public String getGenre() {
    return genre;
}
public String getPublisher() {
    return publisher;
}
public String getNA_sales() {
    return NA_sales;
}
public String getEU_sales() {
    return EU_sales;
}
public String getJP_sales() {
    return JP_sales;
}
public String getOther_sales() {
    return other_sales;
}
public String getGlobal_sales() {
    return global_sales;
}
}
