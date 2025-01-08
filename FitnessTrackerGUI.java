import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FitnessTrackerGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JLabel feedbackLabel;

    public FitnessTrackerGUI() {
        // Set the JFrame properties
        setTitle("Fitness Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Username Field
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        
        // Password Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        
        // Submit Button
        submitButton = new JButton("Register");
        submitButton.addActionListener(new SubmitButtonListener());
        
        // Feedback Label
        feedbackLabel = new JLabel("");
        
        // Add components to the frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(submitButton);
        add(feedbackLabel);
    }
    
    private class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            
            // Basic data validation
            if (username.isEmpty() || password.isEmpty()) {
                feedbackLabel.setText("Username or password cannot be empty.");
            } else if (username.length() < 5) {
                feedbackLabel.setText("Username must be at least 5 characters long.");
            } else {
                feedbackLabel.setText("Registration Successful!");
                // Store user info in database (not implemented in this code)
            }
        }
    }

    public static void main(String[] args) {
        // Run the fitness tracker GUI
        FitnessTrackerGUI frame = new FitnessTrackerGUI();
        frame.setVisible(true);
    }
}
