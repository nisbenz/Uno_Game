package org.example.Special;

import org.example.Special_Card;

public class skip extends Special_Card {

    public int Effect(int current_index,boolean reverse,int n) {
        if (reverse) {
            if(current_index ==0) {
                current_index=n;

            }else{
                current_index--;
            }
        }else{
            if(current_index==n) {
                current_index=0;
            }
            current_index++;
        }
        setEffect(false);
        return current_index;
    }

}
