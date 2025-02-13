package org.example.Special;
import org.example.*;



public class draw4 extends Special_Card {
    public void Effect(Player player, deck Deck) {
        Choose_A_color();
        if (getEffect()) {
            for (int i = 0; i < 4; i++) {
                Deck.Drawing(player);
            }
            setEffect(false);
        }
    }
}
