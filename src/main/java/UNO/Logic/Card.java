package UNO.Logic;
import java.util.Random;

import static UNO.Logic.Card.Color.*;

public abstract class Card {
   public enum Color {red, green, blue, yellow,black}
    private Color color;
    public Card() {
        generate_color();
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    void generate_color(){
        int x;
        Random rand = new Random();
        x=rand.nextInt(4);
        switch(x){
            case 0:
                setColor(red);
                break;
            case 1:
                setColor(green);
                break;
            case 2:
                setColor(blue);
                break;
            case 3:
                setColor(yellow);
                break;
        }
    }

    protected abstract boolean Isitplayable(Card previous);

}

