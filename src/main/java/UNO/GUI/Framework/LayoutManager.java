package UNO.GUI.Framework;

/**
 * Strategy for laying out the children of a Container.
 */
public interface LayoutManager {
    /** Position and size each child in the parent container. */
    void layoutContainer(Container parent);
}