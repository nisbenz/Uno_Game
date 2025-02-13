package org.example.Special;
import org.example.Special_Card;

public class reverse extends Special_Card {
   public void Effect(boolean reverse) {
        if(reverse){
            reverse=false;
        }else {
            reverse=true;
        }
        setEffect(false);
    }




}
