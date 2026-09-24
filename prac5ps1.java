import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prac5ps1 extends JFrame implements ActionListener {
    private JTextField txtName, txtRoll, txtMarks;
    private JButton btnSubmit;
    private JTextArea txtOutput;

    public prac5ps1() {
        setTitle("Student Registration System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Form Labels and Fields
        add(new JLabel("Student Name:"));
        txtName = new JTextField(20);
        add(txtName);

        add(new JLabel("Roll Number:  "));
        txtRoll = new JTextField(20);
        add(txtRoll);

        add(new JLabel("Marks (0-100): "));
        txtMarks = new JTextField(20);
        add(txtMarks);

        // Submit Button
        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        // Output Display Area
        txtOutput = new JTextArea(8, 30);
        txtOutput.setEditable(false);
        add(new JScrollPane(txtOutput));

        setLocationRelativeTo(null); // Center on screen
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = txtName.getText().trim();
        String roll = txtRoll.getText().trim();
        String marksText = txtMarks.getText().trim();

        // 1. Validation for empty fields
        if (name.isEmpty() || roll.isEmpty() || marksText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double marks = Double.parseDouble(marksText);

            if (marks < 0 || marks > 100) {
                JOptionPane.showMessageDialog(this, "Marks must be between 0 and 100.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. Grade Calculation logic
            String grade;
            if (marks >= 90) grade = "A+";
            else if (marks >= 80) grade = "A";
            else if (marks >= 70) grade = "B";
            else if (marks >= 60) grade = "C";
            else if (marks >= 50) grade = "D";
            else grade = "F";

            // 3. Output display
            txtOutput.setText("--- Student Details ---\n" +
                    "Name: " + name + "\n" +
                    "Roll Number: " + roll + "\n" +
                    "Marks: " + marks + "\n" +
                    "Grade: " + grade);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Marks must be a valid number!", "Type Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new prac5ps1().setVisible(true));
    }
}