import java.util.Comparator;

public class SalaryComparator implements Comparator<Player> {
    public int compare(Player o1, Player o2) {
        String PlayerOneSalary = o1.getSalary();
        int PlayerOneSalaryValue = Integer.parseInt(PlayerOneSalary);
        
        String PlayerTwoSalary = o2.getSalary();
        int PlayerTwoSalaryValue = Integer.parseInt(PlayerTwoSalary);
        
        return PlayerTwoSalaryValue - PlayerOneSalaryValue;
    }
}
