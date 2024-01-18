import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Task_5_EmployeePayrollSystem {
    private JFrame frame;
    private JTextField nameTextField, hoursTextField, rateTextField;
    private JTextArea payslipTextArea;
    private Map<String, Employee> employeeMap;

    public Task_5_EmployeePayrollSystem() {
        frame = new JFrame("Employee Payroll System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        employeeMap = new HashMap<>();

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Employee Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        nameTextField = new JTextField(20);
        nameTextField.setBounds(150, 20, 165, 25);
        panel.add(nameTextField);

        JLabel hoursLabel = new JLabel("Worked Hours:");
        hoursLabel.setBounds(10, 50, 150, 25);
        panel.add(hoursLabel);

        hoursTextField = new JTextField(20);
        hoursTextField.setBounds(150, 50, 165, 25);
        panel.add(hoursTextField);

        JLabel rateLabel = new JLabel("Hourly Rate:");
        rateLabel.setBounds(10, 80, 150, 25);
        panel.add(rateLabel);

        rateTextField = new JTextField(20);
        rateTextField.setBounds(150, 80, 165, 25);
        panel.add(rateTextField);

        JButton calculateButton = new JButton("Calculate Payroll");
        calculateButton.setBounds(10, 110, 150, 25);
        panel.add(calculateButton);

        payslipTextArea = new JTextArea();
        payslipTextArea.setBounds(10, 150, 350, 150);
        panel.add(payslipTextArea);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculatePayroll();
            }
        });
    }

    private void calculatePayroll() {
        String name = nameTextField.getText();
        double hoursWorked = Double.parseDouble(hoursTextField.getText());
        double hourlyRate = Double.parseDouble(rateTextField.getText());

        Employee employee = new Employee(name, hoursWorked, hourlyRate);
        employee.calculateSalary();

        String payslip = "Employee Name: " + employee.getName() + "\n" +
                "Hours Worked: " + employee.getHoursWorked() + "\n" +
                "Hourly Rate: Rs" + employee.getHourlyRate() + "\n" +
                "Gross Salary: Rs" + employee.getGrossSalary() + "\n" +
                "Tax Deduction: Rs" + employee.getTax() + "\n" +
                "Net Salary: Rs" + employee.getNetSalary();

        payslipTextArea.setText(payslip);
        employeeMap.put(name, employee);
    }

    private class Employee {
        private String name;
        private double hoursWorked;
        private double hourlyRate;
        private double grossSalary;
        private double tax;
        private double netSalary;

        public Employee(String name, double hoursWorked, double hourlyRate) {
            this.name = name;
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        public String getName() {
            return name;
        }

        public double getHoursWorked() {
            return hoursWorked;
        }

        public double getHourlyRate() {
            return hourlyRate;
        }

        public double getGrossSalary() {
            return grossSalary;
        }

        public double getTax() {
            return tax;
        }

        public double getNetSalary() {
            return netSalary;
        }

        public void calculateSalary() {
            grossSalary = hoursWorked * hourlyRate;
            tax = grossSalary * 0.2; // Assuming 20% tax for simplicity
            netSalary = grossSalary - tax;
        }
    }

    public static void main(String[] args) {
        new Task_5_EmployeePayrollSystem();
    }
}
