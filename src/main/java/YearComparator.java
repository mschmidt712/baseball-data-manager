import java.util.Comparator;

public class YearComparator implements Comparator<Player>{

    public int compare(Player o1, Player o2) {
        String playerOneYearString = o1.getYear();
        int playerOneYear = Integer.parseInt(playerOneYearString);
        String playerTwoYearString = o2.getYear();
        int playerTwoYear = Integer.parseInt(playerTwoYearString);
        
        return playerTwoYear - playerOneYear;
    }

}
