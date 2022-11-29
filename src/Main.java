import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Float> participants = new HashMap<String, Float>();
        participants.put("Kati", 900F);
        participants.put("Peti", 120F);
        participants.put("Mari", 300F);

        CalculateExpensesPerPerson data = new CalculateExpensesPerPerson(participants);
        data.calculateBalancePerPerson();

    }
}