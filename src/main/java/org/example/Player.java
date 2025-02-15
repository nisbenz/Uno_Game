package org.example;
import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private int id;
    private ArrayList<Card> hand = new ArrayList<>();
    public Player(int  id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }
    public void displayHand() {
        if (hand.isEmpty()) {
            System.out.println("Your hand is empty.");
            return;
        }

        // Convert each card's string representation into an array of lines.
        List<String[]> cardLinesList = new ArrayList<>();
        for (Card card : hand) {
            // Split the multi-line string from toString() by newline characters.
            String[] cardLines = card.toString().split("\n");
            cardLinesList.add(cardLines);
        }

        // All cards are assumed to have the same number of lines.
        int numLines = cardLinesList.getFirst().length;

        // Print each line of all cards side by side.
        for (int lineIndex = 0; lineIndex < numLines; lineIndex++) {
            for (int cardIndex = 0; cardIndex < cardLinesList.size(); cardIndex++) {
                System.out.print(cardLinesList.get(cardIndex)[lineIndex]);
                // Print a single space between cards.
                if (cardIndex < cardLinesList.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // Define the card width (should match the one in your toString() method).
        int cardWidth = 28;

        // Now print a new line with the card indices centered below each card.
        for (int cardIndex = 0; cardIndex < cardLinesList.size(); cardIndex++) {
            // Using 1-indexed display (change to cardIndex if you prefer 0-indexed)
            String indexStr = String.valueOf(cardIndex + 1);
            // Calculate left and right padding to center the index within cardWidth.
            int leftPadding = (cardWidth - indexStr.length()) / 2;
            int rightPadding = cardWidth - indexStr.length() - leftPadding;

            // Print the index line for this card.
            System.out.print(" ".repeat(leftPadding) + indexStr + " ".repeat(rightPadding));

            // Print a space between cards if it's not the last card.
            if (cardIndex < cardLinesList.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println(); // End the index line.
    }
    abstract public void play(Card previous, deck  Deck);
    public boolean Game_Over(){
        return hand.isEmpty();
    }



}
