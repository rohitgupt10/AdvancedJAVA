package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleInterestCalculator extends JFrame {
    private JTextField principalField, rateField, timeField, resultField;

    public SimpleInterestCalculator() {
        setTitle("Simple Interest Calculator");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Principal:"));
        principalField = new JTextField();
        add(principalField);

        add(new JLabel("Rate (%):"));
        rateField = new JTextField();
        add(rateField);

        add(new JLabel("Time (years):"));
        timeField = new JTextField();
        add(timeField);

        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);

        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double p = Double.parseDouble(principalField.getText());
                double r = Double.parseDouble(rateField.getText());
                double t = Double.parseDouble(timeField.getText());
                double interest = (p * r * t) / 100;
                resultField.setText(String.valueOf(interest));
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleInterestCalculator();
    }
}

