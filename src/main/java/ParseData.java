import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

public class ParseData {
    private static String salariesFilePath = "./Salaries.csv";
    private static ArrayList<Player> players;
    private static ArrayList<Player> topPaidPlayers;
    
    public static void main(String[] args) {
        ReadFile();
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
    
    @SuppressWarnings("deprecation")
    public static void ReadFile() {
        try {
            CSVReader reader = new CSVReader(new FileReader(salariesFilePath), ',');

            players = new ArrayList<Player>();
            String[] record = null;
            
            while ((record = reader.readNext()) != null) {
                Player player = new Player();
                player.setYear(record[0]);
                player.setTeam(record[1]);
                player.setLeague(record[2]);
                player.setPlayer(record[3]);
                player.setSalary(record[4]);
                
                players.add(player);
            }
            
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
