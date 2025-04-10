package org.example.Special;
import org.example.Card;
import org.example.Special_Card;

public class reverse extends Special_Card {
   public int Effect(int direction) {
       if(getEffect()) {
           direction *= -1;
       }
       setEffect(false);
       return direction;
   }
   public boolean Isitplayable(Card previous) {
        if (previous instanceof Special_Card special) {
            if (!special.getEffect()) {
                return this.getColor() == special.getColor() ||
                        special.getClass().getSimpleName().equals("reverse");
            } else {
                return false;
            }
        } else {
            return this.getColor() == previous.getColor();
        }
   }
}
