package com.campuscare;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageComplaint {

    JFrame frame;

    public ManageComplaint(String complaintId) {

        frame = new JFrame(
                "CampusCare - Manage Complaint"
        );

        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(null);


        // ==============================
        // TITLE
        // ==============================

        JLabel title =
                new JLabel("Manage Complaint");

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        title.setBounds(
                30, 20, 300, 40
        );

        panel.add(title);


        // ==============================
        // COMPLAINT ID
        // ==============================

        JLabel idLabel =
                new JLabel(
                        "Complaint ID: "
                                + complaintId
                );

        idLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        idLabel.setBounds(
                30, 80, 400, 30
        );

        panel.add(idLabel);


        // ==============================
        // STATUS
        // ==============================

        JLabel statusLabel =
                new JLabel("Status:");

        statusLabel.setBounds(
                30, 140, 120, 25
        );

        panel.add(statusLabel);


        String[] statuses = {
                "PENDING",
                "ASSIGNED",
                "IN_PROGRESS",
                "RESOLVED",
                "REJECTED"
        };

        JComboBox<String> statusBox =
                new JComboBox<>(statuses);

        statusBox.setBounds(
                160, 140, 300, 30
        );

        panel.add(statusBox);


        // ==============================
        // ADMIN REMARK
        // ==============================

        JLabel remarkLabel =
                new JLabel("Admin Remark:");

        remarkLabel.setBounds(
                30, 200, 120, 25
        );

        panel.add(remarkLabel);


        JTextArea remarkArea =
                new JTextArea();

        remarkArea.setLineWrap(true);
        remarkArea.setWrapStyleWord(true);

        JScrollPane remarkScroll =
                new JScrollPane(
                        remarkArea
                );

        remarkScroll.setBounds(
                160, 200, 300, 100
        );

        panel.add(remarkScroll);


        // ==============================
        // UPDATE BUTTON
        // ==============================

        JButton updateButton =
                new JButton("Update Complaint");

        updateButton.setBounds(
                160, 340, 180, 40
        );

        panel.add(updateButton);


        // ==============================
        // CANCEL BUTTON
        // ==============================

        JButton cancelButton =
                new JButton("Cancel");

        cancelButton.setBounds(
                350, 340, 110, 40
        );

        panel.add(cancelButton);


        // ==============================
        // UPDATE ACTION
        // ==============================

        updateButton.addActionListener(e -> {

            String newStatus =
                    statusBox
                            .getSelectedItem()
                            .toString();

            String remark =
                    remarkArea
                            .getText()
                            .trim();


            boolean updated =
                    updateComplaint(
                            complaintId,
                            newStatus,
                            remark
                    );


            if (updated) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Complaint updated successfully!"
                );

                frame.dispose();

            } else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Unable to update complaint."
                );
            }

        });


        // ==============================
        // CANCEL ACTION
        // ==============================

        cancelButton.addActionListener(e ->
                frame.dispose()
        );


        // ==============================
        // SHOW WINDOW
        // ==============================

        frame.add(panel);

        frame.setVisible(true);
    }


    // =========================================
    // UPDATE COMPLAINT IN FILE
    // =========================================

    private boolean updateComplaint(
            String complaintId,
            String newStatus,
            String remark) {

        List<String> complaints =
                new ArrayList<>();

        boolean found = false;


        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "data/complaints.txt"
                            )
                    );

            String line;


            while ((line =
                    reader.readLine()) != null) {

                String[] data =
                        line.split("\\|", -1);


                if (data.length >= 7
                        && data[0].equals(complaintId)) {

                    // Update status
                    data[6] = newStatus;

                    found = true;

                    // Add updated line
                    line = String.join(
                            "|",
                            data
                    );
                }

                complaints.add(line);
            }

            reader.close();


            // Rewrite entire file

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter(
                                    "data/complaints.txt"
                            )
                    );


            for (String complaint :
                    complaints) {

                writer.println(complaint);
            }

            writer.close();


            return found;

        } catch (IOException e) {

            e.printStackTrace();

            return false;
        }
    }
}