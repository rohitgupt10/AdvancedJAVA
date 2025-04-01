package GUI;

import javax.swing.*;
import java.awt.*;

public class LayoutDemo {
    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Layout Manager Demo");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JTabbedPane to switch between layouts
        JTabbedPane tabbedPane = new JTabbedPane();

        // FlowLayout Panel
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.add(new JButton("Button 1"));
        flowPanel.add(new JButton("Button 2"));
        flowPanel.add(new JButton("Button 3"));
        tabbedPane.addTab("FlowLayout", flowPanel);

        // GridLayout Panel
        JPanel gridPanel = new JPanel(new GridLayout(4, 2));
        gridPanel.add(new JButton("1"));
        gridPanel.add(new JButton("2"));
        gridPanel.add(new JButton("3"));
        gridPanel.add(new JButton("4"));
        gridPanel.add(new JButton("5"));
        gridPanel.add(new JButton("6"));
        gridPanel.add(new JButton("7"));
        gridPanel.add(new JButton("8"));
        tabbedPane.addTab("GridLayout", gridPanel);

        // BorderLayout Panel
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(new JButton("North"), BorderLayout.NORTH);
        borderPanel.add(new JButton("South"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("West"), BorderLayout.WEST);
        borderPanel.add(new JButton("East"), BorderLayout.EAST);
        borderPanel.add(new JButton("Center"), BorderLayout.CENTER);
        tabbedPane.addTab("BorderLayout", borderPanel);

        // BoxLayout Panel (Vertical)
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.add(new JButton("Button A"));
        boxPanel.add(new JButton("Button B"));
        boxPanel.add(new JButton("Button C"));
        tabbedPane.addTab("BoxLayout", boxPanel);

        // GridBagLayout Panel
        JPanel gridBagPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JButton btn1 = new JButton("Big Button");
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gridBagPanel.add(btn1, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1;
        gridBagPanel.add(new JButton("Small 1"), gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gridBagPanel.add(new JButton("Small 2"), gbc);

        tabbedPane.addTab("GridBagLayout", gridBagPanel);

        // Add tabbedPane to frame
        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}

