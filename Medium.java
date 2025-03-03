import java.util.*;
class Card {
 private String symbol;
 private String value;
 public Card(String symbol, String value) {
 this.symbol = symbol;
 this.value = value;
 }
 public String getSymbol() {
 return symbol;
 }
 public String getValue() {
 return value;
 }
 @Override
 public String toString() {
 return value + " of " + symbol;
 }
}
class CardCollection {
 private Collection<Card> cards;
 public CardCollection() {
 this.cards = new ArrayList<>();
 }
 public void addCard(String symbol, String value) {
 cards.add(new Card(symbol, value));
 }
 public List<Card> findCardsBySymbol(String symbol) {
 List<Card> result = new ArrayList<>();
 for (Card card : cards) {
 if (card.getSymbol().equalsIgnoreCase(symbol)) {
result.add(card);
 }
 }
 return result;
 }
 public void displayAllCards() {
 for (Card card : cards) {
 System.out.println(card);
 }
 }
}
public class CardManager {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 CardCollection collection = new
CardCollection();
 collection.addCard("Hearts", "Ace");
 collection.addCard("Hearts", "King");
 collection.addCard("Diamonds", "Queen");
 collection.addCard("Spades", "Jack");
 collection.addCard("Clubs", "10");
 System.out.println("All cards:");
 collection.displayAllCards();
 System.out.print("\nEnter symbol to search (e.g., Hearts, Diamonds, Spades, Clubs): ");
 String searchSymbol = scanner.nextLine();
 List<Card> foundCards = collection.findCardsBySymbol(searchSymbol);
 if (foundCards.isEmpty()) {
 System.out.println("No cards found for symbol: " + searchSymbol);
 } else {
 System.out.println("Cards found for symbol " + searchSymbol + ":");
 for (Card card : foundCards) {
 System.out.println(card);
 }
 }
 scanner.close();
 }
}
