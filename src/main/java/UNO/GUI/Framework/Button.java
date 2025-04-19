package UNO.GUI.Framework;

import javax.swing.JButton;

/**
 * Clickable button.
 */
public class Button extends Component {
    public Button(String text) {
        peer = new JButton(text);
    }

    /**
     * Override click action.
     */
    public void onClick(Runnable action) {
        addClickListener(action);
    }
}