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


    public String toString() {
        final int cardWidth = 28;
        final int insideWidth = cardWidth - 2; // 26
        StringBuilder sb = new StringBuilder();

        // 1) Horizontal border: 28 characters
        String horizontalBorder = "+" + "-".repeat(insideWidth) + "+\n";
        sb.append(horizontalBorder);

        // 2) Centered Title: "SPECIAL CARD"
        String title = "SPECIAL CARD";
        int leftPadding = (insideWidth - title.length()) / 2;
        int rightPadding = insideWidth - title.length() - leftPadding;
        sb.append("|")
                .append(" ".repeat(leftPadding))
                .append(title)
                .append(" ".repeat(rightPadding))
                .append("|\n");

        sb.append(horizontalBorder);

        // 3) Type line (26 chars inside, no extra space after `|`)
        String typeStr = "Type: " + this.getClass().getSimpleName().toUpperCase();
        sb.append(String.format("|%-" + insideWidth + "s|\n", typeStr));

        // 4) Color line (26 chars inside, no extra space after `|`)
        String colorStr = "Color: " + getColor();
        sb.append(String.format("|%-" + insideWidth + "s|\n", colorStr));

        // 5) Bottom border
        sb.append(horizontalBorder);

        return sb.toString();
    }

    protected void Choose_A_color() {
        boolean chosen = false;
        while (!chosen) {
            System.out.println("pick from these 4 colors : red, blue, green, yellow (from index 1 to 4) :");
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
            if(!special.getEffect()) {
                return special.getColor() == this.getColor()||special.getClass()==this.getClass();
                }else{
                return false;
            }
        }else{
            if(this.getEffect()) {
                switch(this.getClass().getSimpleName()){
                    case "draw4", "draw2","wild":
                        return true;
                    case "skip","reverse":
                        return this.getColor()==previous.getColor();
                }
            }
            return previous.getColor() == this.getColor();
        }
    }
}