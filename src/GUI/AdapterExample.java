package GUI;

import javax.swing.*;
import java.awt.event.*;

public class AdapterExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Adapter Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Click anywhere", SwingConstants.CENTER);
        frame.add(label);

        // Using Adapter Class
        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                label.setText("Clicked at " + e.getX() + ", " + e.getY());
            }
        });

        frame.setVisible(true);
    }
}

