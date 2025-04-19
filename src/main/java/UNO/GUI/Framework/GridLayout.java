package UNO.GUI.Framework;

import java.util.List;

/**
 * Divide the parent into a rows×cols grid, sizing children uniformly.
 */
public class GridLayout implements LayoutManager {
    private final int rows, cols;

    /** @param rows number of rows; @param cols number of columns */
    public GridLayout(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public void layoutContainer(Container parent) {
        List<Component> children = parent.getChildren();
        int pw = parent.getPeer().getWidth();
        int ph = parent.getPeer().getHeight();
        int cellW = pw / cols;
        int cellH = ph / rows;

        for (int i = 0; i < children.size(); i++) {
            int r = i / cols;
            int c = i % cols;
            Component comp = children.get(i);
            comp.setBounds(c * cellW, r * cellH, cellW, cellH);
        }
    }
}