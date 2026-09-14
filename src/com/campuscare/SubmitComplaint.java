package com.campuscare;

import javax.swing.*;
import java.awt.*;

public class SubmitComplaint {

    JFrame frame;

    public SubmitComplaint(String studentName) {

        // ==============================
        // CREATE WINDOW
        // ==============================

        frame = new JFrame("CampusCare - Submit Complaint");

        frame.setSize(650, 550);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        // ==============================
        // MAIN PANEL
        // ==============================

        JPanel panel = new JPanel();
        panel.setLayout(null);


        // ==============================
        // TITLE
        // ==============================

        JLabel title = new JLabel("Submit a Complaint");

        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setBounds(30, 25, 400, 40);

        panel.add(title);


        // Student name

        JLabel studentLabel = new JLabel(
                "Student: " + studentName
        );

        studentLabel.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        studentLabel.setBounds(30, 70, 400, 25);

        panel.add(studentLabel);


        // ==============================
        // CATEGORY
        // ==============================

        JLabel categoryLabel = new JLabel("Category:");

        categoryLabel.setBounds(50, 120, 120, 25);

        panel.add(categoryLabel);


        String[] categories = {
                "Electrical",
                "Internet / Wi-Fi",
                "Cleanliness",
                "Classroom",
                "Hostel",
                "Library",
                "Water",
                "Transport",
                "Academic",
                "Other"
        };

        JComboBox<String> categoryBox =
                new JComboBox<>(categories);

        categoryBox.setBounds(180, 120, 350, 30);

        panel.add(categoryBox);


        // ==============================
        // LOCATION
        // ==============================

        JLabel locationLabel = new JLabel("Location:");

        locationLabel.setBounds(50, 170, 120, 25);

        panel.add(locationLabel);


        JTextField locationField = new JTextField();

        locationField.setBounds(180, 170, 350, 30);

        panel.add(locationField);


        // ==============================
        // PRIORITY
        // ==============================

        JLabel priorityLabel = new JLabel("Priority:");

        priorityLabel.setBounds(50, 220, 120, 25);

        panel.add(priorityLabel);


        String[] priorities = {
                "LOW",
                "MEDIUM",
                "HIGH",
                "URGENT"
        };

        JComboBox<String> priorityBox =
                new JComboBox<>(priorities);

        priorityBox.setBounds(180, 220, 350, 30);

        panel.add(priorityBox);


        // ==============================
        // DESCRIPTION
        // ==============================

        JLabel descriptionLabel =
                new JLabel("Description:");

        descriptionLabel.setBounds(
                50, 270, 120, 25
        );

        panel.add(descriptionLabel);


        JTextArea descriptionArea =
                new JTextArea();

        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);


        JScrollPane scrollPane =
                new JScrollPane(descriptionArea);

        scrollPane.setBounds(
                180, 270, 350, 100
        );

        panel.add(scrollPane);


        // ==============================
        // SUBMIT BUTTON
        // ==============================

        JButton submitButton =
                new JButton("Submit Complaint");

        submitButton.setBounds(
                220, 410, 200, 40
        );

        panel.add(submitButton);


        // ==============================
        // CANCEL BUTTON
        // ==============================

        JButton cancelButton =
                new JButton("Cancel");

        cancelButton.setBounds(
                220, 460, 200, 35
        );

        panel.add(cancelButton);


        // ==============================
        // SUBMIT ACTION
        // ==============================

        submitButton.addActionListener(e -> {

            String category =
                    (String) categoryBox.getSelectedItem();

            String location =
                    locationField.getText().trim();

            String priority =
                    (String) priorityBox.getSelectedItem();

            String description =
                    descriptionArea.getText().trim();


            // Check empty fields

            if (location.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter the location."
                );

                return;
            }


            if (description.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter the complaint description."
                );

                return;
            }


            // Generate complaint ID

            String complaintId =
                    "CMP-2026-" +
                            String.format(
                                    "%04d",
                                    (int)(Math.random() * 10000)
                            );
            // save complain to files
            ComplaintFileManager.saveComplaint(
                    complaintId,
                    studentName,
                    category,
                    location,
                    priority,
                    description
            );


            // Success message

            JOptionPane.showMessageDialog(
                    frame,
                    "Complaint submitted successfully!\n\n"
                            + "Complaint ID: "
                            + complaintId
                            + "\nCategory: "
                            + category
                            + "\nPriority: "
                            + priority,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );


            // Clear form

            locationField.setText("");
            descriptionArea.setText("");

        });


        // ==============================
        // CANCEL ACTION
        // ==============================

        cancelButton.addActionListener(e -> {

            frame.dispose();

        });


        // ==============================
        // SHOW WINDOW
        // ==============================

        frame.add(panel);

        frame.setVisible(true);
    }
}