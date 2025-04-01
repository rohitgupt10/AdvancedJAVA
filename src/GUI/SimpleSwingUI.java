package GUI;

import javax.swing.*;
import java.awt.*;

public class SimpleSwingUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing UI Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        // Labels and Input Fields
        frame.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        frame.add(nameField);

        frame.add(new JLabel("Gender:"));
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        frame.add(genderPanel);

        frame.add(new JLabel("Hobbies:"));
        JCheckBox musicCheck = new JCheckBox("Music");
        JCheckBox sportsCheck = new JCheckBox("Sports");
        JPanel hobbyPanel = new JPanel();
        hobbyPanel.add(musicCheck);
        hobbyPanel.add(sportsCheck);
        frame.add(hobbyPanel);

        frame.add(new JLabel("Country:"));
        String[] countries = {"USA", "UK", "India", "Canada"};
//        JComboBox<String> countryBox = new JComboBox<>(countries);
        JComboBox countryBox = new JComboBox(countries);
        frame.add(countryBox);

        frame.add(new JLabel("Comments:"));
        JTextArea commentArea = new JTextArea(3, 20);
        frame.add(new JScrollPane(commentArea));

        frame.add(new JButton("Submit"));

        frame.setVisible(true);
    }
}

