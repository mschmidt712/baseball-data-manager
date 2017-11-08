import java.util.ArrayList;

public class TopPaidPlayers {
    private static ArrayList<Player> players;
    private static ArrayList<Player> topPaidPlayers;

    public static void main(String[] args) {
        players = ParseData.ReadFile();
        SortPlayers();
        
        FindTopThreePaidPlayer();
        
        for (int i = 0; i < topPaidPlayers.size(); i++) {
            System.out.println(topPaidPlayers.get(i).buildPlayerString());
            System.out.println('\n');
        }
    }
    
    public static ArrayList<Player> FindTopThreePaidPlayer () {
        topPaidPlayers = new ArrayList<Player>();
        
        int numberOfPlayers = 0;
        int index = 0;
        while (numberOfPlayers < 3) {
            Player player = players.get(index);
            
            if (CheckForExistanceOfPlayerInArray(player, topPaidPlayers)) {
                index++;
            } else {
                topPaidPlayers.add(player);
                numberOfPlayers++;
                index++;
            }
        }
        
        return topPaidPlayers;
    }

    public static boolean CheckForExistanceOfPlayerInArray (Player player, ArrayList<Player> array) {
        String name = player.getPlayer();
        
        for (int i = 0; i < array.size(); i++) {
            String arrayPlayerName = array.get(i).getPlayer();
            
            if (arrayPlayerName.equals(name)) {
                return true;
            }
        }

        return false;
    }
    
    public static void SortPlayers () {
        players.sort(new SalaryComparator());
    }
}
