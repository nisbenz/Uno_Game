package org.example;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public  class Special_Card extends Card {

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

    protected void Choose_A_color(Player player) {
        boolean chosen = false;
        int n;
        while (!chosen) {
            if(player instanceof Real_player) {
                System.out.println("pick from these 4 colors : red, blue, green, yellow (from index 1 to 4) :");
                Scanner sc = new Scanner(System.in);
                 n = sc.nextInt();
            }else{
                Random rand = new Random();
                n=rand.nextInt(4);
            }
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
                if(Objects.equals(this.getClass().getSimpleName(), "wild")||Objects.equals(this.getClass().getSimpleName(), "draw4") ){
                    return true;
                }else{
                    return special.getColor() == this.getColor()|| Objects.equals(this.getClass().getSimpleName(), special.getClass().getSimpleName());
                }
                }else{
                return false;
            }
        }else{
            if(this.getEffect()) {
                switch(this.getClass().getSimpleName()){
                    case "draw4","wild":
                        return true;
                    case "skip","reverse","draw2":
                        return this.getColor()==previous.getColor();
                }
            }
            return previous.getColor() == this.getColor();
        }
    }
}