import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogWorkout {
    public LogWorkout() {
        JFrame frame = new JFrame("Log Your Workout");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel exerciseLabel = new JLabel("Enter Exercise Type (e.g., Running): ");
        JTextField exerciseField = new JTextField(20);
        JLabel durationLabel = new JLabel("Duration (minutes): ");
        JTextField durationField = new JTextField(5);
        JButton logButton = new JButton("Log Workout");

        logButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exercise = exerciseField.getText();
                int duration = Integer.parseInt(durationField.getText());
                // Log the workout here (add this functionality, such as saving data to a file or database)
                JOptionPane.showMessageDialog(frame, "Workout Logged: " + exercise + " for " + duration + " minutes.");
                frame.dispose();
            }
        });

        frame.add(exerciseLabel);
        frame.add(exerciseField);
        frame.add(durationLabel);
        frame.add(durationField);
        frame.add(logButton);
        frame.setVisible(true);
    }
}
