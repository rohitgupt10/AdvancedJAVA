package GUI;

import javax.swing.*;
import java.awt.event.*;

public class MouseKeyEvents {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse & Key Events");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Click or Press a Key", SwingConstants.CENTER);
        frame.add(label);

        // Mouse Event
        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked at " + e.getX() + ", " + e.getY());
            }

            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered!");
            }

            public void mouseExited(MouseEvent e) {
                label.setText("Mouse Exited!");
            }
        });

        // Key Event
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                label.setText("Key Pressed: " + e.getKeyChar());
            }
            public void keyTyped(KeyEvent e) {
                label.setText("Key Typed: " + e.getKeyChar());
            }
            public void keyReleased(KeyEvent e) {
                label.setText("Key Released: " + e.getKeyChar());
            }
        });

        frame.setFocusable(true);
        frame.setVisible(true);
    }
}
