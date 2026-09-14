package com.campuscare;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PrincipalDashboard {

    JFrame frame;

    public PrincipalDashboard() {

        frame = new JFrame(
                "CampusCare - Principal Dashboard"
        );

        frame.setSize(900, 650);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();

        panel.setLayout(null);


        // =====================================
        // TITLE
        // =====================================

        JLabel title =
                new JLabel("CAMPUSCARE");

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        title.setBounds(
                30, 20, 300, 40
        );

        panel.add(title);


        // =====================================
        // SUBTITLE
        // =====================================

        JLabel subtitle =
                new JLabel(
                        "Principal Dashboard"
                );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        subtitle.setBounds(
                30, 60, 300, 25
        );

        panel.add(subtitle);


        // =====================================
        // STATISTICS
        // =====================================

        int[] stats =
                getStatistics();

        int total = stats[0];
        int pending = stats[1];
        int inProgress = stats[2];
        int resolved = stats[3];
        int rejected = stats[4];


        // =====================================
        // TOTAL
        // =====================================

        addStat(
                panel,
                "TOTAL",
                String.valueOf(total),
                50,
                110
        );


        // =====================================
        // PENDING
        // =====================================

        addStat(
                panel,
                "PENDING",
                String.valueOf(pending),
                260,
                110
        );


        // =====================================
        // IN PROGRESS
        // =====================================

        addStat(
                panel,
                "IN PROGRESS",
                String.valueOf(inProgress),
                470,
                110
        );


        // =====================================
        // RESOLVED
        // =====================================

        addStat(
                panel,
                "RESOLVED",
                String.valueOf(resolved),
                680,
                110
        );


        // =====================================
        // RESOLUTION RATE
        // =====================================

        double resolutionRate = 0;

        if (total > 0) {

            resolutionRate =
                    ((double) resolved / total) * 100;
        }

        JLabel resolutionLabel =
                new JLabel(
                        String.format(
                                "Resolution Rate: %.1f%%",
                                resolutionRate
                        )
                );

        resolutionLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        resolutionLabel.setBounds(
                50, 220, 350, 35
        );

        panel.add(resolutionLabel);


        // =====================================
        // CATEGORY STATISTICS
        // =====================================

        JLabel categoryTitle =
                new JLabel(
                        "Complaints by Category"
                );

        categoryTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        categoryTitle.setBounds(
                50, 280, 300, 30
        );

        panel.add(categoryTitle);


        Map<String, Integer> categories =
                getCategoryStatistics();


        int y = 330;

        for (Map.Entry<String, Integer> entry :
                categories.entrySet()) {

            JLabel category =
                    new JLabel(
                            entry.getKey()
                                    + " : "
                                    + entry.getValue()
                    );

            category.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            16
                    )
            );

            category.setBounds(
                    70, y, 300, 30
            );

            panel.add(category);

            y += 40;

            // Avoid overflowing the window

            if (y > 520) {
                break;
            }
        }


        // =====================================
        // CLOSE BUTTON
        // =====================================

        JButton closeButton =
                new JButton("Close");

        closeButton.setBounds(
                650, 520, 130, 40
        );

        closeButton.addActionListener(
                e -> frame.dispose()
        );

        panel.add(closeButton);


        // =====================================
        // SHOW WINDOW
        // =====================================

        frame.add(panel);

        frame.setVisible(true);
    }


    // =========================================
    // ADD STAT BOX
    // =========================================

    private void addStat(
            JPanel panel,
            String title,
            String value,
            int x,
            int y) {

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        titleLabel.setBounds(
                x, y, 180, 25
        );

        panel.add(titleLabel);


        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        valueLabel.setBounds(
                x, y + 25, 180, 40
        );

        panel.add(valueLabel);
    }


    // =========================================
    // GET GENERAL STATISTICS
    // =========================================

    private int[] getStatistics() {

        int total = 0;
        int pending = 0;
        int inProgress = 0;
        int resolved = 0;
        int rejected = 0;


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


                if (data.length >= 7) {

                    total++;

                    String status = data[6];


                    switch (status) {

                        case "PENDING":
                            pending++;
                            break;

                        case "IN_PROGRESS":
                            inProgress++;
                            break;

                        case "RESOLVED":
                            resolved++;
                            break;

                        case "REJECTED":
                            rejected++;
                            break;
                    }
                }
            }

            reader.close();

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Unable to read complaints."
            );
        }


        return new int[]{
                total,
                pending,
                inProgress,
                resolved,
                rejected
        };
    }


    // =========================================
    // GET CATEGORY STATISTICS
    // =========================================

    private Map<String, Integer>
    getCategoryStatistics() {

        Map<String, Integer> categories =
                new HashMap<>();


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


                if (data.length >= 7) {

                    String category = data[2];

                    categories.put(
                            category,
                            categories.getOrDefault(
                                    category,
                                    0
                            ) + 1
                    );
                }
            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }


        return categories;
    }
}