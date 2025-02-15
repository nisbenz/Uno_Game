package org.example;
import java.util.ArrayList;
import org.example.Special.*;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private deck Deck = new deck();
        Game(int nbrOfRealPlayers) {
            Player player;
            for (int i = 0; i < nbrOfRealPlayers; i++) {
                player =new Real_player(i+1);
                players.add(player);
            }
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
            Card previous = new Normal_Card();
            int currentindex = 0;
            while (!Game_Over) {
                switch (previous.getClass().getSimpleName()) {
                    case "draw4":
                        ((draw4) previous).Effect(players.get(currentindex), getDeck());
                        break;
                    case "draw2":
                        ((draw2) previous).Effect(players.get(currentindex), getDeck());
                        break;
                    case "wild":
                        ((wild) previous).Effect();
                        break;
                    case "skip":
                        currentindex = ((skip) previous).Effect(currentindex, reverse, players.size() - 1);
                        break;
                    case "reverse":
                        reverse = ((reverse) previous).Effect(reverse);
                        break;
                }
                if (previous.getClass().getSimpleName().equals("draw2") || previous.getClass().getSimpleName().equals("draw4")) {
                    skip card = new skip();
                    currentindex = card.Effect(currentindex, reverse, players.size() - 1);
                }
                System.out.println("------------Player number " + players.get(currentindex).getId() + " turn-------------");
                System.out.println("here's the previous card");
                System.out.println(previous);
                players.get(currentindex).play(previous,getDeck());
// Check if the *current* player ended the game
                if (players.get(currentindex).Game_Over()) {
                    Game_Over = true;
                    // Possibly break out of the loop here, or return, etc.
                }
// Now move to the next player
                if (reverse) {
                    currentindex = (currentindex + players.size() - 1) % players.size();
                } else {
                    currentindex = (currentindex + 1) % players.size();
                }
// Update 'previous' after the current player’s turn
                previous = getDeck().getTopCard();
            }
        }
        deck getDeck(){
            return Deck;
        }
}
