package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Real_player extends Player {
    Real_player(int id) {
        super(id);
    }

    public void play(Card previous, deck Deck) {
        if(!Canplay(previous)){
                System.out.println("Player number " + getId() + " has to draw a card from the deck");
                Deck.Drawing(this);
                System.out.println("Player number " + getId() + " drew this card");
                System.out.println(getHand().getLast());
                return;
        }
        boolean heplayed = false;
        System.out.println("------------Player number " + getId() + " turn");
        System.out.println("here's the previous card");
        System.out.println(previous);
        System.out.println("here's your hand");
        displayHand();
        while (!heplayed) {
            System.out.println("Pick a card from index 1 to " + getHand().size());
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            System.out.println(getHand().get(choice - 1).Isitplayable(previous));
            if (choice < 1 || choice > getHand().size()) {
                System.out.println("Invalid input");
            } else if (getHand().get(choice - 1).Isitplayable(previous)) {
                System.out.println("Player number " + getId() + " has played this card");
                System.out.println(getHand().get(choice - 1));
                Deck.Discarding(this, choice - 1);
                heplayed = true;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
    public boolean Canplay(Card previous) {
        for (int i = 0; i < getHand().size(); i++) {
            if (getHand().get(i).Isitplayable(previous)) {
                return true;
            }
        }
        return false;
    }
}