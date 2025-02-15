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
    public String toString() {
        final int cardWidth = 28;
        // The inside width is everything between the two '|' characters.
        final int insideWidth = cardWidth - 2; // 26

        StringBuilder sb = new StringBuilder();

        // 1) Horizontal border: + followed by 26 '-' then + = 28 chars total
        String horizontalBorder = "+" + "-".repeat(insideWidth) + "+\n";
        sb.append(horizontalBorder);

        // 2) Centered Title: "NORMAL CARD"
        String title = "NORMAL CARD";
        // Calculate how many spaces go to the left and right
        int leftPadding = (insideWidth - title.length()) / 2;
        int rightPadding = insideWidth - title.length() - leftPadding;

        sb.append("|")
                .append(" ".repeat(leftPadding))
                .append(title)
                .append(" ".repeat(rightPadding))
                .append("|\n");

        // Another horizontal border
        sb.append(horizontalBorder);

        // 3) Color line: exactly 28 chars wide
        //    "|Color: <...>.............|"
        //    We remove the extra space after '|', so we use "|%-26s|\n"
        String colorStr = "Color: " + getColor();
        sb.append(String.format("|%-" + insideWidth + "s|\n", colorStr));

        // 4) Number line
        String numberStr = "Number: " + getNum();
        sb.append(String.format("|%-" + insideWidth + "s|\n", numberStr));

        // Final horizontal border
        sb.append(horizontalBorder);

        return sb.toString();
    }
    boolean Isitplayable(Card previous){
        if(previous instanceof Normal_Card){
            return ((Normal_Card) previous).getNum() == this.getNum() ||previous.getColor() == this.getColor();
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
