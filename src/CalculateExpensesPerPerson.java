import java.util.HashMap;
import java.util.LinkedList;

import static java.lang.Math.abs;

public class CalculateExpensesPerPerson {
    private HashMap<String, Float> participants;
    private int numOfOverpayingPerson = 0;
    private int sumOfOverpayment = 0;
    private LinkedList<String> overpayingPersons = new LinkedList<String>();
    private int numOfParticipants;

    public CalculateExpensesPerPerson() {}

    public CalculateExpensesPerPerson(HashMap<String, Float> participants)
    {
        this.participants = participants;
        numOfParticipants = participants.size();
    }

    public HashMap<String, Float> getParticipants() {
        return participants;
    }

    public void setParticipants(HashMap<String, Float> participants) {
        this.participants = participants;
    }

    private void calculateExpenses()
    {
        int sumOfAllExpanses = 0;
        int expansesPerPerson;

        for(String i : participants.keySet())
        {
            sumOfAllExpanses += participants.get(i);
        }

        expansesPerPerson = sumOfAllExpanses / numOfParticipants;

        for(String j : participants.keySet())
        {
            if((participants.get(j) - expansesPerPerson) > 0)
            {
                overpayingPersons.add(j);
                numOfOverpayingPerson ++;
                sumOfOverpayment += (participants.get(j) - expansesPerPerson);
            }
            participants.put(j,(participants.get(j) - expansesPerPerson));
        }
    }

    public void calculateBalancePerPerson()
    {
        float debt;
        calculateExpenses();
        float ratio;

        for(String name : overpayingPersons)
        {
            System.out.println("Tartoznak neki: " + name);
            for(String person : participants.keySet())
            {
                if(!person.equals(name) && participants.get(person) > 0)
                {
                    if (participants.get(name) < participants.get(person))
                    {
                        debt = 0;
                        System.out.println(person + " ennyivel: " + abs(debt));
                    }
                    else if(participants.get(name) > participants.get(person))
                    {
                        debt = (participants.get(name)/(numOfParticipants-1)) - (participants.get(person)/(numOfParticipants-1));
                        System.out.println(person + " ennyivel: " + abs(debt));
                    }
                }
                else if(!person.equals(name) && participants.get(person) < 0)
                {
                    ratio = participants.get(name)/sumOfOverpayment;
                    debt = participants.get(person) * ratio;
                    System.out.println(person + " ennyivel: " + abs(debt));
                }

            }
        }
    }
}
