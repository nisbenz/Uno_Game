package org.example.Special;
import org.example.Player;
import org.example.Special_Card;


public class wild extends Special_Card {
   public void Effect(Player player) {
        Choose_A_color(player);
        setEffect(false);
    }



}
