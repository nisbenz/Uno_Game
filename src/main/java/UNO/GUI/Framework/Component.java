package UNO.GUI.Framework;


import javax.swing.JComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Base wrapper for any visual component.
 */
public abstract class Component {
    protected JComponent peer;

    /** Returns the underlying Swing component. */
    public JComponent getPeer() {
        return peer;
    }

    /** Position and size within its parent. */
    public void setBounds(int x, int y, int width, int height) {
        peer.setBounds(x, y, width, height);
    }

    /** Register a click callback. */
    public void addClickListener(Runnable action) {
        peer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                action.run();
            }
        });
    }
}
