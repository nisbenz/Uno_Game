package org.example;
import java.util.Collections;
import java.util.Stack;
import java.util.Random;
import org.example.Special.*;


public class deck {
    Stack<Card> Draw;
    Stack<Card> Discard;

    void initdeck() {
        Draw = new Stack<>();
        Discard = new Stack<>();
        int cpt = 0;
        for (int i = 0; i < 108; i++) {
            Card gen = null;
            if (cpt < 40) {
                generate_special_Card();
                cpt++;
            } else {
                gen = new Normal_Card();
            }
            Draw.push(gen);
        }
        Collections.shuffle(Draw);
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
    void generate_special_Card(){
        Random rand = new Random();
        int x=rand.nextInt(5);
        Special_Card card = switch (x) {
            case 0 -> new draw2();
            case 1 -> new draw4();
            case 2 -> new reverse();
            case 3 -> new skip();
            case 4 -> new wild();
            default -> null;
        };
        card.Displaycard();
            Draw.push(card);

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
    public Card getFirstCard() {
        Card card = Draw.pop();
        Discard.push(card);
        return card;
    }
    public Card getTopCard() {
        return Discard.peek();

    }
}