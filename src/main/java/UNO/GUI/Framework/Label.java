package UNO.GUI.Framework;

import javax.swing.JLabel;

/**
 * Simple text label.
 */
public class Label extends Component {
    public Label(String text) {
        peer = new JLabel(text);
    }

    /** Adjust font size if needed. */
    public void setFontSize(int size) {
        peer.setFont(peer.getFont().deriveFont((float) size));
    }
}
