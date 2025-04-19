package UNO.Logic.Special;

import UNO.Logic.Card;
import UNO.Logic.Special_Card;

public class skip extends Special_Card {
    public  int Effect(int current_index,int direction,int n) {
        current_index = (current_index + n +direction) % n;
        setEffect(false);
        return current_index;
    }
    public boolean Isitplayable(Card previous) {
        if (previous instanceof Special_Card special) {
            if (!special.getEffect()) {
                return this.getColor() == special.getColor() ||
                        special.getClass().getSimpleName().equals("skip");
            } else {
                return false;
            }
        } else {
            return this.getColor() == previous.getColor();
        }
    }

}
