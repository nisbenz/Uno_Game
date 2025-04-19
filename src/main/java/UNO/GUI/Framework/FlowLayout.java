package UNO.GUI.Framework;

import java.util.List;

/**
 * Simple horizontal flow layout with fixed spacing.
 */
public class FlowLayout implements LayoutManager {
    private final int paddingX, paddingY, componentWidth, componentHeight;

    /**
     * @param paddingX horizontal gap between components
     * @param paddingY vertical gap from top
     * @param componentWidth fixed width for each child
     * @param componentHeight fixed height for each child
     */
    public FlowLayout(int paddingX, int paddingY, int componentWidth, int componentHeight) {
        this.paddingX = paddingX;
        this.paddingY = paddingY;
        this.componentWidth = componentWidth;
        this.componentHeight = componentHeight;
    }

    @Override
    public void layoutContainer(Container parent) {
        List<Component> children = parent.getChildren();
        int x = paddingX;
        for (Component c : children) {
            c.setBounds(x, paddingY, componentWidth, componentHeight);
            x += componentWidth + paddingX;
        }
    }
}
