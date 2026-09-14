package com.campuscare;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ComplaintFileManager {

    private static final String FILE_PATH =
            "data/complaints.txt";


    // =========================================
    // SAVE COMPLAINT
    // =========================================

    public static void saveComplaint(
            String complaintId,
            String studentName,
            String category,
            String location,
            String priority,
            String description) {

        try {

            // Create data folder if it doesn't exist
            File dataFolder = new File("data");

            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }


            // Open file in APPEND mode
            FileWriter fileWriter =
                    new FileWriter(FILE_PATH, true);

            PrintWriter writer =
                    new PrintWriter(fileWriter);


            // Save complaint
            writer.println(
                    complaintId + "|" +
                            studentName + "|" +
                            category + "|" +
                            location + "|" +
                            priority + "|" +
                            description + "|" +
                            "PENDING"
            );


            // Close file
            writer.close();

            System.out.println(
                    "Complaint saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error saving complaint."
            );

            e.printStackTrace();
        }
    }
}