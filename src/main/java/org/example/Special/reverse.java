package org.example.Special;
import org.example.Special_Card;

public class reverse extends Special_Card {
   public int Effect(int direction) {
       if(getEffect()) {
           direction *= -1;
       }
       setEffect(false);
       return direction;
    }





}
