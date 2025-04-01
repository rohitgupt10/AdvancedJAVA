package GUI;

import javax.swing.*;
import java.awt.*;

public class DrawShapes extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(50, 50, 100, 100); // Draw Circle

        g.setColor(Color.BLUE);
        g.fillRect(200, 50, 150, 100); // Draw Rectangle

        g.setColor(Color.GREEN);
        int[] xPoints = {100, 150, 50};
        int[] yPoints = {200, 300, 300};
        g.fillPolygon(xPoints, yPoints, 3); // Draw Polygon
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new DrawShapes());
        frame.setVisible(true);
    }
}
