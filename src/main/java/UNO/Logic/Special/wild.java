package UNO.Logic.Special;
import UNO.Logic.Card;
import UNO.Logic.Player;
import UNO.Logic.Special_Card;


public class wild extends Special_Card {
   public void Effect(Player player) {
       if (getEffect()) {
           Choose_A_color(player);
           setEffect(false);
       }
   }
    public boolean Isitplayable(Card previous) {
        if (previous instanceof Special_Card special) {
            return !special.getEffect();
        } else {
            return true;
        }
    }
}
