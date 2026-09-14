package com.campuscare;

import javax.swing.*;
import java.awt.*;

public class StudentDashboard {

    JFrame frame;

    public StudentDashboard(String studentName) {

        // Create window
        frame = new JFrame("CampusCare - Student Dashboard");

        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ==============================
        // TITLE
        // ==============================

        JLabel title = new JLabel("CAMPUSCARE");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBounds(30, 20, 250, 40);

        panel.add(title);

        // Subtitle
        JLabel subtitle = new JLabel(
                "College Complaint Management System"
        );

        subtitle.setFont(new Font("Arial", Font.PLAIN, 13));
        subtitle.setBounds(30, 60, 300, 25);

        panel.add(subtitle);

        // ==============================
        // STUDENT NAME
        // ==============================

        JLabel welcome = new JLabel(
                "Welcome, " + studentName + "!"
        );

        welcome.setFont(new Font("Arial", Font.BOLD, 22));
        welcome.setBounds(30, 110, 400, 35);

        panel.add(welcome);

        // Description
        JLabel description = new JLabel(
                "Manage and track your college complaints."
        );

        description.setFont(new Font("Arial", Font.PLAIN, 14));
        description.setBounds(30, 145, 400, 25);

        panel.add(description);

        // ==============================
        // SUBMIT COMPLAINT BUTTON
        // ==============================

        JButton submitButton = new JButton("Submit Complaint");

        submitButton.setBounds(80, 210, 220, 60);

        panel.add(submitButton);

        // ==============================
        // MY COMPLAINTS BUTTON
        // ==============================

        JButton myComplaintsButton = new JButton("My Complaints");

        myComplaintsButton.setBounds(380, 210, 220, 60);

        panel.add(myComplaintsButton);

        // ==============================
        // TRACK COMPLAINT BUTTON
        // ==============================

        JButton trackButton = new JButton("Track Complaint");

        trackButton.setBounds(80, 300, 220, 60);

        panel.add(trackButton);

        // ==============================
        // LOGOUT BUTTON
        // ==============================

        JButton logoutButton = new JButton("Logout");

        logoutButton.setBounds(380, 300, 220, 60);

        panel.add(logoutButton);

        // ==============================
        // BUTTON ACTIONS
        // ==============================

        submitButton.addActionListener(e -> {

            new SubmitComplaint(studentName);

        });

        myComplaintsButton.addActionListener(e -> {

            new MyComplaints(studentName);

        });

        trackButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Track Complaint feature coming soon!"
            );

        });

        logoutButton.addActionListener(e -> {

            frame.dispose();

            JOptionPane.showMessageDialog(
                    null,
                    "You have been logged out."
            );

        });
        // Add panel
        frame.add(panel);

        // Show window
        frame.setVisible(true);
    }
}