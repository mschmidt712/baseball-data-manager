import java.util.ArrayList;
import java.util.TreeMap;

public class MeanPayPerYear {
    private static ArrayList<Player> players = ParseData.ReadFile();
    private static TreeMap<String, Long> meanPayPerYear = new TreeMap<String, Long>();
    
    public static void main(String[] args) {
        buildMeanPayPerYear();
    }
    
    private static void buildMeanPayPerYear () {        
        String currentYear = players.get(0).getYear();
        int numberOfPlayers = 1;
        long totalSalary = Integer.parseInt(players.get(0).getSalary());;
        
        for (int i = 1; i < players.size(); i++) {
            String currentPlayerYear = players.get(i).getYear();
            String pastPlayerYear = players.get(i - 1).getYear();
            String currentPlayerSalaryString = players.get(i).getSalary();
            int currentPlayerSalary = Integer.parseInt(currentPlayerSalaryString);

            if (currentPlayerYear.equals(pastPlayerYear)) {
                currentYear = currentPlayerYear;
                totalSalary += currentPlayerSalary;
                
                numberOfPlayers++;
            } else {
                long meanSalary = totalSalary/numberOfPlayers;
                meanPayPerYear.put(currentYear, meanSalary);
                System.out.println(currentYear);
                System.out.println(meanSalary);
                
                currentYear = currentPlayerYear;
                numberOfPlayers = 1;
                totalSalary = currentPlayerSalary;  
            }
        }
    }
    
    private static void SortPlayersByYear () {
        players.sort(new YearComparator());
    }
}
