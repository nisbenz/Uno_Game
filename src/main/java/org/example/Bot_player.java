package org.example;
import java.util.ArrayList;
import java.util.Random;

public class Bot_player extends Player{
    Bot_player(int id){
        super(id);
    }
    public void play(Card previous,deck Deck){
        ArrayList <Card> Usablecard=Canplay(previous);
        if(Usablecard.isEmpty()){
            System.out.println("Bot number " + getId() + " has to draw a card from the deck");
            Deck.Drawing(this);
            System.out.println("Bot number " + getId() + " drew this card");
            System.out.println(getHand().getLast());
            return;
        }
        Random rand = new Random();
        int n= rand.nextInt(Usablecard.size());
        displayHand();
        System.out.println("the bot has chosen this card");
        System.out.println(Usablecard.get(n));
        Deck.Discarding(this,Usablecard.get(n));
    }
    public ArrayList<Card> Canplay(Card previous) {
        ArrayList<Card> Usablecard  = new ArrayList<>();
        for (int i = 0; i < getHand().size(); i++) {
            if (getHand().get(i).Isitplayable(previous)) {
                Usablecard.add(getHand().get(i));
            }
        }
        return Usablecard;
    }
}

