package org.example;
import java.util.ArrayList;
import org.example.Special.*;

public class Game {
    private final ArrayList<Player> players = new ArrayList<>();
    private final deck Deck = new deck();
        public Game(int nbrOfRealPlayers, int nbrOfBotPlayers) {
            Player player;
            for (int i = 0; i < nbrOfRealPlayers; i++) {
                player =new Real_player(i+1);
                players.add(player);
            }
            for (int i = 0; i < nbrOfBotPlayers; i++) {
                player =new Bot_player(i+1+nbrOfRealPlayers);
                players.add(player);
            }

            Serve_players();

        }
        void  Serve_players(){
            for (Player player : players) {
                for (int i = 0; i < 7; i++) {
                    Deck.Drawing(player);
                }
            }
        }
        void Start() {
            boolean Game_Over = false;
            int direction =1;
            Card previous = new Normal_Card();
            skip card = new skip();
            int currentindex = 0;
            while (!Game_Over) {
                System.out.println("------------Player number " + players.get(currentindex).getId() + " turn-------------");

                System.out.println("here's the previous card");
                System.out.println(previous);
                players.get(currentindex).play(previous,Deck);
               Space();
                previous =Deck.getTopCard();
                int next=(currentindex + players.size()+direction) % players.size();
                switch (previous.getClass().getSimpleName()) {
                    case "draw4":
                        ((draw4) previous).Effect(players.get(next),Deck);
                        break;
                    case "draw2":
                        ((draw2) previous).Effect(players.get(next), Deck);
                        break;
                    case "wild":
                        ((wild) previous).Effect(players.get(currentindex));
                        break;
                    case "skip":
                        currentindex = ((skip) previous).Effect(currentindex,direction, players.size());
                        break;
                    case "reverse":
                        direction = ((reverse) previous).Effect(direction);
                        break;
                }

                if (players.get(currentindex).Game_Over()) {
                    Game_Over = true;
                }
                currentindex = (currentindex + players.size() +direction) % players.size();
                if (previous.getClass().getSimpleName().equals("draw2") || previous.getClass().getSimpleName().equals("draw4")) {
                    currentindex = card.Effect(currentindex, direction, players.size());
                }

            }
        }
        void Space(){
            for (int i = 0; i < 7; i++) {
                System.out.println("\t");
            }

        }
}
