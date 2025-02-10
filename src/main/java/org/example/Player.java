package org.example;
import java.util.ArrayList;

public abstract class Player {
    private int id;
    private ArrayList<Card> hand = new ArrayList<>();
    public Player(int  id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {}
    public ArrayList<Card> getHand() {
        return hand;
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public void DisplayHand() {
        if (hand.isEmpty()) {
            System.out.println("Your hand is empty!");
            return;
        }

        // A list to store each card's display lines (split by newline)
        ArrayList<String[]> cardsAsLines = new ArrayList<>();
        int maxLines = 0;

        // Convert each card's display string into an array of lines.
        for (Card card : hand) {
            // Assuming displayCard() returns a multi-line string
            String cardRepresentation = card.Displaycard();
            String[] lines = cardRepresentation.split("\n");
            cardsAsLines.add(lines);

            // Track the maximum number of lines among all cards
            if (lines.length > maxLines) {
                maxLines = lines.length;
            }
        }

        // For each line index (from 0 to maxLines-1), combine the corresponding lines from all cards.
        for (int line = 0; line < maxLines; line++) {
            StringBuilder combinedLine = new StringBuilder();

            // Append each card's corresponding line or spaces if that card has fewer lines.
            for (String[] cardLines : cardsAsLines) {
                if (line < cardLines.length) {
                    combinedLine.append(cardLines[line]);
                } else {
                    // Append blank spaces for cards with fewer lines (assuming card width is 28 characters)
                    combinedLine.append(" ".repeat(28));
                }
                // Add a few spaces between cards
                combinedLine.append("   ");
            }
            // Print the combined line for this row.
            System.out.println(combinedLine.toString());
        }
    }
    abstract public void play(Card previous, deck  Deck);
    public boolean Game_Over(){
        if(hand.isEmpty()){
            return true;
        }else{
            return false;
        }
    }



}
