import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FitnessTracker {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FitnessTrackerGUI::new);
    }
}

class FitnessTrackerGUI {

    private JFrame frame;
    private JTextField nameField, ageField, weightField, stepsField;
    private JTextArea progressArea;
    private ArrayList<User> users;

    public FitnessTrackerGUI() {
        users = new ArrayList<>();
        initGUI();
    }

    private void initGUI() {
        frame = new JFrame("Online Fitness Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("User Details"));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Weight (kg):"));
        weightField = new JTextField();
        inputPanel.add(weightField);

        inputPanel.add(new JLabel("Steps Walked:"));
        stepsField = new JTextField();
        inputPanel.add(stepsField);

        JButton addButton = new JButton("Add User");
        addButton.addActionListener(new AddUserListener());
        inputPanel.add(addButton);

        JButton calculateButton = new JButton("Calculate Progress");
        calculateButton.addActionListener(new CalculateProgressListener());
        inputPanel.add(calculateButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        progressArea = new JTextArea();
        progressArea.setEditable(false);
        progressArea.setBorder(BorderFactory.createTitledBorder("Progress Tracker"));
        frame.add(new JScrollPane(progressArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = nameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                double weight = Double.parseDouble(weightField.getText().trim());
                int steps = Integer.parseInt(stepsField.getText().trim());

                if (name.isEmpty() || age <= 0 || weight <= 0 || steps < 0) {
                    throw new IllegalArgumentException("Invalid input values.");
                }

                User user = new User(name, age, weight, steps);
                users.add(user);
                progressArea.append("User added: " + user + "\n");

                nameField.setText("");
                ageField.setText("");
                weightField.setText("");
                stepsField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for Age, Weight, and Steps.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class CalculateProgressListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (users.isEmpty()) {
                progressArea.append("No users to calculate progress for.\n");
                return;
            }

            progressArea.append("\nCalculating progress:\n");
            for (User user : users) {
                double caloriesBurned = user.getSteps() * 0.04;
                progressArea.append(user.getName() + " burned " + String.format("%.2f", caloriesBurned) + " calories today.\n");
            }
        }
    }
}

class User {
    private String name;
    private int age;
    private double weight;
    private int steps;

    public User(String name, int age, double weight, int steps) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Weight: " + weight + " kg, Steps: " + steps + ")";
    }
}
