package com.campuscare;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AllComplaints {

    JFrame frame;

    public AllComplaints() {

        frame = new JFrame("CampusCare - All Complaints");
        frame.setSize(900, 550);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ==============================
        // TITLE
        // ==============================

        JLabel title = new JLabel("All Complaints");

        title.setFont(
                new Font("Arial", Font.BOLD, 26)
        );

        title.setBounds(30, 20, 300, 40);

        panel.add(title);


        // ==============================
        // TABLE
        // ==============================

        String[] columns = {
                "Complaint ID",
                "Student",
                "Category",
                "Location",
                "Priority",
                "Status"
        };

        DefaultTableModel model =
                new DefaultTableModel(columns, 0);

        JTable table = new JTable(model);

        table.setRowHeight(30);

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBounds(
                30, 80, 820, 300
        );

        panel.add(scrollPane);


        // ==============================
        // LOAD COMPLAINTS
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

                String[] data =
                        line.split("\\|");

                if (data.length >= 7) {

                    model.addRow(
                            new Object[]{
                                    data[0],
                                    data[1],
                                    data[2],
                                    data[3],
                                    data[4],
                                    data[6]
                            }
                    );
                }
            }

            reader.close();

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Unable to read complaints."
            );
        }


        // ==============================
        // MANAGE BUTTON
        // ==============================

        JButton manageButton =
                new JButton("Manage Complaint");

        manageButton.setBounds(
                300, 410, 220, 40
        );

        panel.add(manageButton);


        // ==============================
        // CLOSE BUTTON
        // ==============================

        JButton closeButton =
                new JButton("Close");

        closeButton.setBounds(
                540, 410, 120, 40
        );

        panel.add(closeButton);


        // ==============================
        // MANAGE ACTION
        // ==============================

        manageButton.addActionListener(e -> {

            int selectedRow =
                    table.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a complaint first."
                );

                return;
            }


            String complaintId =
                    model.getValueAt(
                            selectedRow,
                            0
                    ).toString();


            new ManageComplaint(
                    complaintId
            );

        });


        // ==============================
        // CLOSE ACTION
        // ==============================

        closeButton.addActionListener(e ->
                frame.dispose()
        );


        // ==============================
        // SHOW WINDOW
        // ==============================

        frame.add(panel);

        frame.setVisible(true);
    }
}