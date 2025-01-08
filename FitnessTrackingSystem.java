import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FitnessTrackingSystem extends JFrame {
    private JTextField nameField, workoutField, mealField;
    private JButton saveButton;
    private JTextArea logArea;

    public FitnessTrackingSystem() {
        setTitle("Online Fitness Tracking System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // User input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel workoutLabel = new JLabel("Workout Log:");
        workoutField = new JTextField();
        JLabel mealLabel = new JLabel("Meal Log:");
        mealField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(workoutLabel);
        inputPanel.add(workoutField);
        inputPanel.add(mealLabel);
        inputPanel.add(mealField);

        add(inputPanel, BorderLayout.NORTH);

        // Log area to display input data
        logArea = new JTextArea();
        logArea.setEditable(false);
        add(new JScrollPane(logArea), BorderLayout.CENTER);

        // Save button to save data
        saveButton = new JButton("Save Log");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String workout = workoutField.getText();
                String meal = mealField.getText();

                logArea.append("User: " + name + "\n");
                logArea.append("Workout: " + workout + "\n");
                logArea.append("Meal: " + meal + "\n");
                logArea.append("--------------------------\n");

                // Optionally save data to file or database here
                saveData(name, workout, meal);
            }
        });

        add(saveButton, BorderLayout.SOUTH);
    }

    private void saveData(String name, String workout, String meal) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("fitness_log.txt", true))) {
            writer.write("User: " + name + "\n");
            writer.write("Workout: " + workout + "\n");
            writer.write("Meal: " + meal + "\n");
            writer.write("--------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FitnessTrackingSystem frame = new FitnessTrackingSystem();
                frame.setVisible(true);
            }
        });
    }
}
