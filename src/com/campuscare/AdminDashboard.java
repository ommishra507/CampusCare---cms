package com.campuscare;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class AdminDashboard {

    JFrame frame;

    public AdminDashboard() {

        // ==============================
        // CREATE WINDOW
        // ==============================

        frame = new JFrame(
                "CampusCare - Admin Dashboard"
        );

        frame.setSize(800, 550);
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);


        // ==============================
        // MAIN PANEL
        // ==============================

        JPanel panel = new JPanel();

        panel.setLayout(null);


        // ==============================
        // TITLE
        // ==============================

        JLabel title = new JLabel(
                "CAMPUSCARE"
        );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        title.setBounds(
                30,
                25,
                300,
                40
        );

        panel.add(title);


        // ==============================
        // SUBTITLE
        // ==============================

        JLabel subtitle = new JLabel(
                "Admin Dashboard"
        );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        subtitle.setBounds(
                30,
                65,
                300,
                25
        );

        panel.add(subtitle);


        // ==============================
        // WELCOME
        // ==============================

        JLabel welcome = new JLabel(
                "Welcome, Administrator!"
        );

        welcome.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        welcome.setBounds(
                30,
                120,
                400,
                35
        );

        panel.add(welcome);


        // ==============================
        // TOTAL COMPLAINTS
        // ==============================

        JLabel totalLabel = new JLabel(
                "Total Complaints"
        );

        totalLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        totalLabel.setBounds(
                80,
                190,
                200,
                30
        );

        panel.add(totalLabel);


        JLabel totalNumber = new JLabel(
                "0"
        );

        totalNumber.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        totalNumber.setBounds(
                80,
                220,
                100,
                40
        );

        panel.add(totalNumber);


        // ==============================
        // PENDING
        // ==============================

        JLabel pendingLabel = new JLabel(
                "Pending"
        );

        pendingLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        pendingLabel.setBounds(
                280,
                190,
                200,
                30
        );

        panel.add(pendingLabel);


        JLabel pendingNumber = new JLabel(
                "0"
        );

        pendingNumber.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        pendingNumber.setBounds(
                280,
                220,
                100,
                40
        );

        panel.add(pendingNumber);


        // ==============================
        // RESOLVED
        // ==============================

        JLabel resolvedLabel = new JLabel(
                "Resolved"
        );

        resolvedLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        resolvedLabel.setBounds(
                480,
                190,
                200,
                30
        );

        panel.add(resolvedLabel);


        JLabel resolvedNumber = new JLabel(
                "0"
        );


        resolvedNumber.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        resolvedNumber.setBounds(
                480,
                220,
                100,
                40
        );

        panel.add(resolvedNumber);
        int[] statistics = getStatistics();

        totalNumber.setText(
                String.valueOf(statistics[0])
        );

        pendingNumber.setText(
                String.valueOf(statistics[1])
        );

        resolvedNumber.setText(
                String.valueOf(statistics[2])
        );


        // ==============================
        // VIEW COMPLAINTS BUTTON
        // ==============================

        JButton viewButton = new JButton(
                "View All Complaints"
        );

        viewButton.setBounds(
                150,
                330,
                220,
                55
        );

        panel.add(viewButton);


        // ==============================
        // LOGOUT BUTTON
        // ==============================

        JButton logoutButton = new JButton(
                "Logout"
        );

        logoutButton.setBounds(
                430,
                330,
                220,
                55
        );

        panel.add(logoutButton);


        // ==============================
        // BUTTON ACTIONS
        // ==============================

        viewButton.addActionListener(e -> {

            new AllComplaints();

        });


        logoutButton.addActionListener(e -> {

            frame.dispose();

            JOptionPane.showMessageDialog(
                    null,
                    "Admin logged out."
            );

        });


        // ==============================
        // SHOW WINDOW
        // ==============================

        frame.add(panel);

        frame.setVisible(true);
    }
    // =========================================
// GET COMPLAINT STATISTICS
// =========================================

    private int[] getStatistics() {

        int total = 0;
        int pending = 0;
        int resolved = 0;

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "data/complaints.txt"
                            )
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split("\\|", -1);

                if (data.length >= 7) {

                    total++;

                    String status = data[6];

                    if (status.equals("PENDING")) {

                        pending++;

                    } else if (status.equals("RESOLVED")) {

                        resolved++;
                    }
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "Error reading complaints file."
            );

            e.printStackTrace();
        }

        return new int[]{
                total,
                pending,
                resolved
        };
    }
}