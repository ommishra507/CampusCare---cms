package com.campuscare;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyComplaints {

    JFrame frame;

    public MyComplaints(String studentName) {

        // ==============================
        // CREATE WINDOW
        // ==============================

        frame = new JFrame("CampusCare - My Complaints");

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        // ==============================
        // TITLE
        // ==============================

        JLabel title = new JLabel("My Complaints");

        title.setFont(
                new Font("Arial", Font.BOLD, 26)
        );

        title.setBounds(30, 20, 300, 40);


        // ==============================
        // TABLE
        // ==============================

        String[] columns = {
                "Complaint ID",
                "Category",
                "Location",
                "Priority",
                "Status"
        };

        DefaultTableModel model =
                new DefaultTableModel(columns, 0);


        JTable table = new JTable(model);

        table.setRowHeight(30);

        table.setFont(
                new Font("Arial", Font.PLAIN, 13)
        );

        table.getTableHeader().setFont(
                new Font("Arial", Font.BOLD, 13)
        );


        // ==============================
        // READ COMPLAINT FILE
        // ==============================

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "data/complaints.txt"
                            )
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                // Make sure data is valid
                if (data.length >= 7) {

                    String complaintId = data[0];
                    String name = data[1];
                    String category = data[2];
                    String location = data[3];
                    String priority = data[4];
                    String status = data[6];


                    // Only show current student's complaints

                    if (name.equals(studentName)) {

                        model.addRow(
                                new Object[]{
                                        complaintId,
                                        category,
                                        location,
                                        priority,
                                        status
                                }
                        );
                    }
                }
            }

            reader.close();

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Unable to read complaints file."
            );

        }


        // ==============================
        // SCROLL PANE
        // ==============================

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBounds(
                30, 80, 720, 280
        );


        // ==============================
        // CLOSE BUTTON
        // ==============================

        JButton closeButton =
                new JButton("Close");

        closeButton.setBounds(
                320, 390, 120, 35
        );

        closeButton.addActionListener(e ->
                frame.dispose()
        );


        // ==============================
        // PANEL
        // ==============================

        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.add(title);
        panel.add(scrollPane);
        panel.add(closeButton);


        // ==============================
        // SHOW WINDOW
        // ==============================

        frame.add(panel);

        frame.setVisible(true);
    }
}