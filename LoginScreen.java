import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fitness Tracker - Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Basic validation for username and password
                if (username.equals("user") && password.equals("password")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful");
                    new Dashboard(); // Open the Dashboard if login is successful
                    frame.dispose(); // Close login screen
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
                }
            }
        });

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.setVisible(true);
    }
}
