package org.example.Special;

import org.example.Special_Card;

public class skip extends Special_Card {

    public  int Effect(int current_index,int direction,int n) {
        current_index = (current_index + n +direction) % n;
        setEffect(false);
        return current_index;
    }

}
