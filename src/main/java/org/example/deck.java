package org.example;
import java.util.Collections;
import java.util.Stack;


public class deck {
    Stack<Card> Draw;
    Stack<Card> Discard;

    void initdeck() {
        int cpt = 0;
        for (int i = 0; i < 108; i++) {
            Card gen;
            if (cpt < 40) {
                gen = new Special_Card();
                cpt++;
            } else {
                gen = new Normal_Card();
            }
            if (i == 106) {
                Collections.shuffle(Draw);
            }
            assert Draw != null;
            Draw.push(gen);
        }
    }

    deck() {
        initdeck();
    }

    public void restart() {
        if (Draw.empty()) {
            Card card = null;
            while (!Discard.empty()) {
                card = Discard.pop();
                Draw.push(Discard.pop());
            }
            Collections.shuffle(Draw);
            Discard.push(card);
        }
    }

    public void Drawing(Player player) {
        if (!Draw.empty()) {
            player.getHand().add(Draw.pop());
        } else {
            restart();
        }
    }
    public void Discarding(Player player, int index) {
        Card card = player.getHand().get(index);
        Discard.push(card);
        player.getHand().remove(index);
    }
    public Card getTopCard() {
        Card card = Draw.pop();
        Discard.push(card);
        return card;
    }
}