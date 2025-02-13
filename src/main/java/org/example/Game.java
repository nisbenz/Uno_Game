package org.example;
import java.util.ArrayList;
import org.example.Special.*;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private deck Deck = new deck();
    private int direction;
        Game(int nbrOfRealPlayers) {
            Player player;
            for (int i = 0; i < nbrOfRealPlayers; i++) {
                player =new Real_player(i+1);
                players.add(player);
            }
            this.direction = 1;
            Serve_players();

        }
        void  Serve_players(){
            for (Player player : players) {
                for (int i = 0; i < 7; i++) {
                    getDeck().Drawing(player);
                }
                player.DisplayHand();
            }

        }
        void Start() {
            boolean Game_Over = false;
            boolean reverse = false;
            Card previous = getDeck().getFirstCard();
            int currentindex = 0;
            while (!Game_Over) {
                players.get(currentindex).play(previous, getDeck());
                    switch (previous.getClass().getSimpleName()) {
                        case "draw4":
                                ((draw4) previous).Effect(players.get(currentindex),getDeck());
                            break;
                        case "draw2":
                            ((draw2) previous).Effect(players.get(currentindex),getDeck());
                            break;
                        case "wild":
                            ((wild) previous).Effect();
                            break;
                        case "skip":
                            ((skip) previous).Effect(currentindex,reverse,players.size());
                            break;
                        case "reverse":
                            ((reverse) previous).Effect(reverse);
                            break;
                    }
                    if (reverse) {
                        reverseDirection();
                    }
                    // Move to the next player using the current direction.
                    currentindex = (currentindex + direction + players.size()) % players.size();
                if (players.get(currentindex).Game_Over()) {
                    Game_Over = true;
                }
                previous = getDeck().getTopCard();
            }
        }
        ArrayList<Player> getplayers(){
            return players;
        }
        deck getDeck(){
            return Deck;
        }
        void setDeck(deck d){
            Deck = d;
        }
    private void reverseDirection() {
        direction *= -1;
    }
}
