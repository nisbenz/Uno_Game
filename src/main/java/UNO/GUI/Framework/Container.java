package UNO.GUI.Framework;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;

/**
 * A container that can hold other Components, laid out by a LayoutManager.
 */
public class Container extends Component {
    private final List<Component> children = new ArrayList<>();
    private LayoutManager layout;

    public Container(LayoutManager layout) {
        this.layout = layout;
        peer = new JPanel(null);  // absolute positioning; our layout will set bounds
    }

    /** Add a child, then re‐layout. */
    public void add(Component c) {
        children.add(c);
        peer.add(c.getPeer());
        layout.layoutContainer(this);
    }

    public List<Component> getChildren() {
        return children;
    }

    public LayoutManager getLayout() {
        return layout;
    }

    /** Change layout manager and re‐layout. */
    public void setLayout(LayoutManager layout) {
        this.layout = layout;
        layout.layoutContainer(this);
    }
}
