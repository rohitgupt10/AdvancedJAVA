package JDBC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CRUDWithSwing extends JFrame {
    private JTextField idField, nameField, ageField;
    private JButton addButton, updateButton, deleteButton, loadButton;
    private JTable table;
    private DefaultTableModel tableModel;

    private Connection conn;

    public CRUDWithSwing() {
        setTitle("JDBC CRUD with Swing");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel with form fields
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        loadButton = new JButton("Load Data");

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(loadButton);

        add(panel, BorderLayout.NORTH);

        // Table to display data
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Age"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Connect to Database
        connectToDatabase();

        // Button Listeners
        addButton.addActionListener(e -> addRecord());
        updateButton.addActionListener(e -> updateRecord());
        deleteButton.addActionListener(e -> deleteRecord());
        loadButton.addActionListener(e -> loadData());

        setVisible(true);
    }

    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Connection Failed!");
            e.printStackTrace();
        }
    }

    private void addRecord() {
        try {
            String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(idField.getText()));
            stmt.setString(2, nameField.getText());
            stmt.setInt(3, Integer.parseInt(ageField.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Added!");
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateRecord() {
        try {
            String sql = "UPDATE students SET name=?, age=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nameField.getText());
            stmt.setInt(2, Integer.parseInt(ageField.getText()));
            stmt.setInt(3, Integer.parseInt(idField.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Updated!");
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteRecord() {
        try {
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(idField.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Deleted!");
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        try {
            tableModel.setRowCount(0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                tableModel.addRow(new Object[]{rs.getInt("id"), rs.getString("name"), rs.getInt("age")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CRUDWithSwing();
    }
}
