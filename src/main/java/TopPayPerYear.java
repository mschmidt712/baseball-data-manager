import java.util.ArrayList;
import java.util.TreeMap;

public class TopPayPerYear {
    private static ArrayList<Player> players = ParseData.ReadFile();
    private static TreeMap<String, Integer> meanPayPerYear = new TreeMap<String, Integer>();
    
    public static void main(String[] args) {
        buildMeanPayPerYear();
    }
    
    private static void buildMeanPayPerYear () {
        SortPlayersByYear();
        
        String currentYear = players.get(0).getYear();
        int topValue = Integer.parseInt(players.get(0).getSalary());
        
        for (int i=1; i < players.size(); i++) {
            String currentPlayerYear = players.get(i).getYear();
            String pastPlayerYear = players.get(i - 1).getYear();
            String currentPlayerSalaryString = players.get(i).getSalary();
            int currentPlayerSalary = Integer.parseInt(currentPlayerSalaryString);

            if (currentPlayerYear.equals(pastPlayerYear)) {
                currentYear = currentPlayerYear;

                if (topValue < currentPlayerSalary) {
                    topValue = currentPlayerSalary;
                }
            } else {
                meanPayPerYear.put(currentYear, topValue);
                System.out.println(currentYear);
                System.out.println(topValue);
                
                currentYear = currentPlayerYear;
                topValue = currentPlayerSalary;
            }
        }
    }
    
    private static void SortPlayersByYear() {
        players.sort(new YearComparator());
    }
}
