package UNO.GUI.Framework;

public class Test {
    public static void main(String[] args) {
        // Build a window
        Window win = new Window("Framework Smoke Test", 400, 200);

        // Root container with horizontal flow of buttons and labels
        Container root = new Container(new FlowLayout(10, 20, 100, 30));
        for (int i = 1; i <= 3; i++) {
            Button b = new Button("Btn " + i);
            b.onClick(() -> System.out.println("Clicked!"));
            root.add(b);
        }
        Label lbl = new Label("Hello, UNO‑GUI!");
        root.add(lbl);

        win.setContent(root);
        win.show();
    }

    public static class HandView {
    }
}
