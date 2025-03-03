import java.util.*;

class Card { 
    String symbol; 
    int number; 

    Card(String symbol, int number) { 
        this.symbol = symbol; 
        this.number = number; 
    } 
} 

public class Experiment5 { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter Number of Cards :"); 
        int n = sc.nextInt(); 
        Map<String, List<Card>> cardMap = new TreeMap<>(); 

        for (int i = 1; i <= n; i++) { 
            System.out.println("Enter card " + i + ":"); 
            String symbol = sc.next(); 
            int number = sc.nextInt(); 
            cardMap.putIfAbsent(symbol, new ArrayList<>()); 
            cardMap.get(symbol).add(new Card(symbol, number)); 
        } 

        System.out.println("Distinct Symbols are :"); 
        for (String symbol : cardMap.keySet()) { 
            System.out.print(symbol + " "); 
        } 
        System.out.println(); 

        for (Map.Entry<String, List<Card>> entry : cardMap.entrySet()) { 
            String symbol = entry.getKey(); 
            List<Card> cards = entry.getValue(); 
            System.out.println("Cards in " + symbol + " Symbol"); 
            int sum = 0; 
            for (Card card : cards) { 
                System.out.println(card.symbol + " " + card.number); 
                sum += card.number; 
            } 
            System.out.println("Number of cards : " + cards.size()); 
            System.out.println("Sum of Numbers : " + sum); 
        } 
        sc.close(); 
    } 
}
