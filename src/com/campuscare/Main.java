package com.campuscare;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // Create the main window
        JFrame frame = new JFrame("CampusCare");

        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Title
        JLabel title = new JLabel("CAMPUSCARE");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBounds(150, 30, 250, 40);

        panel.add(title);

        // Subtitle
        JLabel subtitle = new JLabel("College Complaint Management System");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setBounds(115, 75, 300, 25);

        panel.add(subtitle);

        // Email label
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 130, 100, 25);

        panel.add(emailLabel);

        // Email input
        JTextField emailField = new JTextField();
        emailField.setBounds(180, 130, 220, 30);

        panel.add(emailField);

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 180, 100, 25);

        panel.add(passwordLabel);

        // Password input
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(180, 180, 220, 30);

        panel.add(passwordField);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(180, 240, 100, 35);

        panel.add(loginButton);

        // Login button action
        loginButton.addActionListener(e -> {

            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (email.equals("student@campuscare.com")
                    && password.equals("123456")) {

                frame.dispose();

                new StudentDashboard("Om Mishra");

            } else if (email.equals("admin@campuscare.com")
                    && password.equals("admin123")) {

                frame.dispose();

                new AdminDashboard();

            } else if (email.equals("principal@campuscare.com")
                    && password.equals("principal123")) {

                frame.dispose();

                new PrincipalDashboard();

            } else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid email or password!"
                );
            }
        });

        // Add panel to frame
        frame.add(panel);

        // Display window
        frame.setVisible(true);
    }
}