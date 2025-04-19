package UNO.Logic.Special;
import UNO.Logic.Card;
import UNO.Logic.Player;
import UNO.Logic.Special_Card;
import UNO.Logic.deck;

public class draw2 extends Special_Card {
    public void Effect(Player player, deck Deck) {
        if (getEffect()) {
            for (int i = 0; i < 2; i++) {
                Deck.Drawing(player);

            }
            System.out.println("player number  "+player.getId()+" drew these cards");
            int n =player.getHand().size();
                System.out.println(player.getHand().get(n-1));
                System.out.println(player.getHand().get(n-2));
            setEffect(false);
        }
    }
    public boolean Isitplayable(Card previous) {
        if (previous instanceof Special_Card special) {
            if (!special.getEffect()) {
                return this.getColor() == special.getColor() ||
                        special.getClass().getSimpleName().equals("draw2");
            } else {
                return false;
            }
        } else {
            return this.getColor() == previous.getColor();
        }
    }
}
