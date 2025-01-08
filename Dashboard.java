import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard {
    public Dashboard() {
        JFrame frame = new JFrame("Fitness Tracker - Dashboard");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel welcomeLabel = new JLabel("Welcome to Your Fitness Dashboard!");
        JButton logWorkoutButton = new JButton("Log Workout");
        JButton viewHistoryButton = new JButton("View History");
        JButton calculateCaloriesButton = new JButton("Calculate Calories Burned");

        logWorkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LogWorkout(); // Opens the workout logging window
            }
        });

        viewHistoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // View workout history (extend this feature)
                JOptionPane.showMessageDialog(frame, "Feature Coming Soon");
            }
        });

        calculateCaloriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Example calculation for calories burned
                String exerciseType = JOptionPane.showInputDialog(frame, "Enter Exercise Type (e.g., Running, Cycling): ");
                int duration = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Duration (minutes): "));
                int caloriesBurned = calculateCalories(exerciseType, duration);
                JOptionPane.showMessageDialog(frame, "Calories Burned: " + caloriesBurned);
            }
        });

        frame.add(welcomeLabel);
        frame.add(logWorkoutButton);
        frame.add(viewHistoryButton);
        frame.add(calculateCaloriesButton);
        frame.setVisible(true);
    }

    private int calculateCalories(String exerciseType, int duration) {
        // Simplified calorie estimation logic
        int calories = 0;
        switch (exerciseType.toLowerCase()) {
            case "running":
                calories = duration * 10; // Rough estimate
                break;
            case "cycling":
                calories = duration * 8; // Rough estimate
                break;
            default:
                calories = duration * 5; // General estimate for other activities
                break;
        }
        return calories;
    }
}
