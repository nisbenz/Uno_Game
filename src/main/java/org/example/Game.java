package org.example;
import java.util.ArrayList;

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
            }
        }
        void Start() {
            boolean Game_Over = false;
            boolean reverse = false;
            Card previous = getDeck().getFirstCard();
            int currentindex = 0;
            while (!Game_Over) {
                players.get(currentindex).play(previous, getDeck());
                if (previous instanceof Special_Card) {
                    switch (((Special_Card) previous).getType()) {
                        case draw2:
                            ((Special_Card) previous).draw2_Effect(((Special_Card) previous).getEffect(), players.get(currentindex), getDeck());
                            break;
                        case skip:
                            ((Special_Card) previous).skip_Effect(currentindex, reverse, players.size());
                            break;
                        case reverse:
                            ((Special_Card) previous).reverse_Effect(reverse, this);
                            break;
                        case wild:
                            ((Special_Card) previous).wild_Effect(((Special_Card) previous).getEffect());
                            break;
                        case draw4:
                            ((Special_Card) previous).draw4_Effect(((Special_Card) previous).getEffect(), players.get(currentindex), getDeck());
                            break;
                    }

                    if (reverse) {
                        reverseDirection();
                    }
                    // Move to the next player using the current direction.
                    currentindex = (currentindex + direction + players.size()) % players.size();
                }
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
