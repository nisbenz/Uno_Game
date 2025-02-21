package org.example;
import org.example.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;

public class GUI {



        public static void main(String[] args) {
            // Create a new frame
            Frame frame = new Frame("Uno Game");

            // Create a button
            Button button = new Button("Start Game");
            button.setBounds(50, 100, 80, 30);

            // Add an ActionListener to the button
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String realPlayersStr = JOptionPane.showInputDialog(null, "Enter the number of real players:");
                        // If user cancels, realPlayersStr could be null
                        if (realPlayersStr == null) {
                            // Handle cancel case if needed, e.g. return;
                            return;
                        }
                        int input1 = Integer.parseInt(realPlayersStr);

                        String botPlayersStr = JOptionPane.showInputDialog(null, "Enter the number of Bot players:");
                        if (botPlayersStr == null) {
                            // Handle cancel case if needed
                            return;
                        }
                        int input2 = Integer.parseInt(botPlayersStr);

                        // Successfully parsed both integers, now create the game object
                        Game game = new Game(input1, input2);
                        game.Start();
                        // ... do something with game

                    } catch (NumberFormatException e1) {
                        // This catches invalid integer input
                        System.out.println("Please enter a valid integer!");
                    }
                }
            });

            // Add button to the frame and set frame properties
            frame.add(button);
            frame.setSize(200, 200);
            frame.setLayout(null);
            frame.setVisible(true);
        }
}
