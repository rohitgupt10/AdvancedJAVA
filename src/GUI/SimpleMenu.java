package GUI;

import javax.swing.*;

public class SimpleMenu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JMenuBar menuBar = new JMenuBar();

        // Main menu
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        // Submenu
        JMenu newMenu = new JMenu("New");
        JMenuItem newFile = new JMenuItem("File");
        JMenuItem newFolder = new JMenuItem("Folder");
        newMenu.add(newFile);
        newMenu.add(newFolder);

        // Adding items to menus
        fileMenu.add(newMenu);
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Save"));

        editMenu.add(new JMenuItem("Cut"));
        editMenu.add(new JMenuItem("Copy"));

        // Add menus to bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);

    }
}
