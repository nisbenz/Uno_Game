package org.example;
import java.util.ArrayList;

public abstract class Player {
    private int id;
    private ArrayList<Card> hand;
    public Player(int  id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {}
    public ArrayList<Card> getHand() {
        return hand;
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public void DisplayHand() {}
    abstract public void play(Card previous, deck  Deck);
    public boolean Game_Over(){
        if(hand.isEmpty()){
            return true;
        }else{
            return false;
        }
    }


}
