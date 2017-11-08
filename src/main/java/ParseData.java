import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

public class ParseData {
    private static String salariesFilePath = "/Users/mschmidt/Salaries.csv";
    
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try {
            CSVReader reader = new CSVReader(new FileReader(salariesFilePath), ',');

            ArrayList<Player> players = new ArrayList<Player>();
            String[] record = null;
            
            while ((record = reader.readNext()) != null) {
                Player player = new Player();
                player.setYear(record[0]);
                player.setTeam(record[1]);
                player.setLeague(record[2]);
                player.setPlayer(record[3]);
                player.setSalary(record[4]);
                
                players.add(player);
                System.out.println(player.buildPlayerString());
            }
            
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
