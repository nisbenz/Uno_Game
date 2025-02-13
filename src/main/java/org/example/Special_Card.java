package org.example;
import java.util.Scanner;

public class Special_Card extends Card {

    private boolean effect = true;
    public Special_Card() {
        super();
    }
    public void setEffect(boolean effect) {
        this.effect = effect;
    }

    public boolean getEffect() {
        return effect;
    }


    public String Displaycard() {
        StringBuilder sb = new StringBuilder();

        // Define a fixed card width (you can adjust this as needed)
        final int cardWidth = 28;

        // Create a horizontal border based on the card width
        String horizontalBorder = "+" + "-".repeat(cardWidth - 2) + "+\n";

        // Append the top border
        sb.append(horizontalBorder);

        // Create and append a centered title "SPECIAL CARD"
        String title = "SPECIAL CARD";
        int padding = (cardWidth - 2 - title.length()) / 2;
        String titleLine = "|"
                + " ".repeat(padding)
                + title
                + " ".repeat(cardWidth - 2 - title.length() - padding)
                + "|\n";
        sb.append(titleLine);

        // Append a divider border
        sb.append(horizontalBorder);

        // Append the card's type (displayed in uppercase for clarity)
        String typeStr = "Type: " + this.getClass().getSimpleName().toUpperCase();
        String typeLine = String.format("| %-"+(cardWidth - 2)+"s|\n", typeStr);
        sb.append(typeLine);

        // Append the card's color
        String colorStr = "Color: " + getColor();
        String colorLine = String.format("| %-"+(cardWidth - 2)+"s|\n", colorStr);
        sb.append(colorLine);

        // Append the bottom border
        sb.append(horizontalBorder);

        return sb.toString();
    }
    protected void Choose_A_color() {
        boolean chosen = false;
        while (!chosen) {
            System.out.println("pick from these 4 colors : red,blue,green,yellow (from index 1 to 4)");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            if (n < 1 || n > 4) {
                System.out.println("Please enter a valid index");
            } else {
                switch (n) {
                    case 1:
                        setColor(Color.red);
                        break;
                    case 2:
                        setColor(Color.blue);
                        break;
                    case 3:
                        setColor(Color.green);
                        break;
                    case 4:
                        setColor(Color.yellow);
                        break;
                }
                chosen = true;
            }
        }
    }
    boolean Isitplayable(Card previous) {
        if (previous instanceof Special_Card special) {
            if (!special.getEffect()) {
                return special.getColor() == getColor() || special.getClass()==this.getClass();
            }else{
                return false;
            }
        }else{
            return previous.getColor() == getColor();
        }
    }
}
