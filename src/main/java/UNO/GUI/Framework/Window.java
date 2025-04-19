package UNO.GUI.Framework;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Top‑level window wrapping JFrame.
 */
public class Window {
    private final JFrame frame;

    /**
     * @param title window title
     * @param width initial width
     * @param height initial height
     */
    public Window(String title, int width, int height) {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);  // absolute; our content pane is a Container
    }

    /** Set the root container (your own Container). */
    public void setContent(Container root) {
        frame.setContentPane(root.getPeer());
        // re‐layout on resize:
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                root.getLayout().layoutContainer(root);
            }
        });
    }

    /** Show the window (on the EDT). */
    public void show() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }
}
