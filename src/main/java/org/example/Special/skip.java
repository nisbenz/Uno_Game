package org.example.Special;

import org.example.Special_Card;

public class skip extends Special_Card {

    public void Effect(int current_index,boolean reverse,int n) {
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

}
