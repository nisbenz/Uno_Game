package org.example;

import java.util.Random;
import java.util.Scanner;

public class Special_Card extends Card {
    public enum Type {skip, reverse, draw2, draw4, wild}

    private Type type;
    private boolean effect = true;

    public Special_Card() {
        generate_type();

    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setEffect(boolean effect) {
        this.effect = effect;
    }

    public boolean getEffect() {
        return effect;
    }

    void reverse_Effect(boolean reverse, Game game) {
       if(reverse==true){
           reverse=false;
       }else {
           reverse=true;
       }
       setEffect(false);
    }

    void draw2_Effect(boolean effect,Player player, deck Deck) {
        if (effect) {
            for (int i = 0; i < 2; i++) {
                Deck.Drawing(player);

            }
            setEffect(false);
        }
    }

    void wild_Effect(boolean effect) {
        Choose_A_color();
        setEffect(false);
    }
    void draw4_Effect(boolean effect,Player player, deck Deck) {
        Choose_A_color();
        if (effect) {
            for (int i = 0; i < 4; i++) {
                Deck.Drawing(player);
            }
            setEffect(false);
        }
    }

    void skip_Effect(int current_index,boolean reverse,int n) {
        if (reverse) {
            if(current_index ==0) {
                current_index=n;
            }else{
                current_index--;
            }
        }else{
        current_index++;
    }
        setEffect(false);
}
    void generate_type() {
        int x;
        Random rand = new Random();
        x = rand.nextInt(5);
        switch (x) {
            case 0:
                setType(Type.skip);
                break;
            case 1:
                setType(Type.reverse);
                break;
            case 2:
                setType(Type.draw2);
                break;
            case 3:
                setType(Type.draw4);
                setColor(Color.black);
                break;
            case 4:
                setType(Type.wild);
                setColor(Color.black);
                break;
        }
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
        String typeStr = "Type: " + getType().toString().toUpperCase();
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
    void Choose_A_color(){
        boolean chosen=false;
        System.out.println("pick from these 4 colors : red,blue,green,yellow (from index 1 to 4)");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<1||n>4) {
            System.out.println("Please enter a valid index");
        }else{
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
            chosen=true;
        }
    }
    boolean Isitplayable(Card previous) {
        if (previous instanceof Special_Card special) {
            if (!special.getEffect()) {
                return special.getColor() == getColor() || special.getType() == getType();
            }else{
                return false;
            }
        }else{
            return previous.getColor() == getColor();
        }
    }
}
