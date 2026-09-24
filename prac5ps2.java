import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prac5ps2 extends JFrame implements ActionListener {
    private JTextField txtEmpName, txtEmpId, txtBasicSalary;
    private JButton btnCalculate;
    private JTextArea txtOutput;

    public prac5ps2() {
        setTitle("Employee Salary Calculator");
        setSize(400, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Form Fields
        add(new JLabel("Employee Name:"));
        txtEmpName = new JTextField(20);
        add(txtEmpName);

        add(new JLabel("Employee ID:    "));
        txtEmpId = new JTextField(20);
        add(txtEmpId);

        add(new JLabel("Basic Salary:    "));
        txtBasicSalary = new JTextField(20);
        add(txtBasicSalary);

        // Action Button
        btnCalculate = new JButton("Calculate Salary");
        btnCalculate.addActionListener(this);
        add(btnCalculate);

        // Output Display Area
        txtOutput = new JTextArea(9, 30);
        txtOutput.setEditable(false);
        add(new JScrollPane(txtOutput));

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = txtEmpName.getText().trim();
        String id = txtEmpId.getText().trim();
        String salaryText = txtBasicSalary.getText().trim();

        // 1. Validation
        if (name.isEmpty() || id.isEmpty() || salaryText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double basicSalary = Double.parseDouble(salaryText);

            if (basicSalary < 0) {
                JOptionPane.showMessageDialog(this, "Basic Salary cannot be negative.", "Value Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. Calculations
            double hra = 0.20 * basicSalary;
            double da = 0.10 * basicSalary;
            double grossSalary = basicSalary + hra + da;

            // 3. Display
            txtOutput.setText("--- Salary Breakdown ---\n" +
                    "Employee ID: " + id + "\n" +
                    "Employee Name: " + name + "\n" +
                    "Basic Salary: ₹" + String.format("%.2f", basicSalary) + "\n" +
                    "HRA (20%): ₹" + String.format("%.2f", hra) + "\n" +
                    "DA (10%): ₹" + String.format("%.2f", da) + "\n" +
                    "--------------------------\n" +
                    "Gross Salary: ₹" + String.format("%.2f", grossSalary));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric value for Basic Salary.", "Type Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new prac5ps2().setVisible(true));
    }
}