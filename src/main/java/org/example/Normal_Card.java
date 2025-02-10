package org.example;
import java.util.Random;

public class Normal_Card extends Card {
    private int num;
    public Normal_Card() {
        generatevalue();
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    void generatevalue(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(10);
        setNum(x);
    }
    String Displaycard(){
        StringBuilder sb = new StringBuilder();

        // Define the card's width (adjust as needed)
        final int cardWidth = 28;

        // Create a horizontal border line based on card width
        String horizontalBorder = "+" + "-".repeat(cardWidth - 2) + "+\n";

        // Build the card string
        sb.append(horizontalBorder);

        // Center the title "NORMAL CARD" in the card
        String title = "NORMAL CARD";
        int padding = (cardWidth - 2 - title.length()) / 2;
        String titleLine = "|" + " ".repeat(padding) + title + " ".repeat(cardWidth - 2 - title.length() - padding) + "|\n";
        sb.append(titleLine);
        sb.append(horizontalBorder);

        // Display the card's color
        String colorStr = "Color: " + getColor();
        // Left align within a fixed width
        String colorLine = String.format("| %-"+(cardWidth - 2)+"s|\n", colorStr);
        sb.append(colorLine);

        // Display the card's number
        String numberStr = "Number: " + getNum();
        String numberLine = String.format("| %-"+(cardWidth - 2)+"s|\n", numberStr);
        sb.append(numberLine);

        sb.append(horizontalBorder);

        return sb.toString();
    }
    boolean Isitplayable(Card previous){
        if(previous instanceof Normal_Card){
            return ((Normal_Card) previous).getNum() == this.getNum() || ((Normal_Card) previous).getColor() == this.getColor();
        }else{
            if(previous instanceof  Special_Card){
                if(((Special_Card) previous).getEffect()){
                    return false;
                }else{
                    return previous.getColor() == this.getColor();
                }
            }
        }
        return false;
    }

}
