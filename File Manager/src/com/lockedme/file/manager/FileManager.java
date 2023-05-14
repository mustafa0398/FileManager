package com.lockedme.file.manager;

import java.io.*;
import java.util.*;

public class FileManager {

    private static final String ROOT_DIR = "C:\\myfiles";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String option = "";
        while (!option.equals("3")) {
            printWelcomeScreen();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    displayFilesInAscendingOrder();
                    break;
                case "2":
                    displayFileOperations();
                    String fileOption = scanner.nextLine();
                    executeFileOperation(fileOption, scanner);
                    break;
                case "3":
                    System.out.println("Closing the application.");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
            }
        }
        scanner.close();
    }

    private static void printWelcomeScreen() {
        System.out.println("Welcome to LockedMe.com application!");
        System.out.println("Developer: Mustafa Öztürk");
        System.out.println("Please select an option:");
        System.out.println("1. Display files in ascending order");
        System.out.println("2. File operations (Add, Delete, Search)");
        System.out.println("3. Close the application");
    }

    private static void displayFilesInAscendingOrder() {
        System.out.println("Displaying files in ascending order\n");
        File dir = new File(ROOT_DIR);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files found in the directory.");
            return;
        }
        Arrays.sort(files);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    private static void displayFileOperations() {
        System.out.println("Please select a file operation:");
        System.out.println("1. Add a file");
        System.out.println("2. Delete a file");
        System.out.println("3. Search a file");
        System.out.println("4. Go back to main context");
    }

    private static void executeFileOperation(String fileOption, Scanner scanner) {
        switch (fileOption) {
            case "1":
                System.out.println("Please enter the name of the file to add:");
                String addFileName = scanner.nextLine();
                addFile(addFileName);
                break;
            case "2":
                System.out.println("Please enter the name of the file to delete:");
                String deleteFileName = scanner.nextLine();
                deleteFile(deleteFileName);
                break;
            case "3":
                System.out.println("Please enter the name of the file to search:");
                String searchFileName = scanner.nextLine();
                searchFile(searchFileName);
                break;
            case "4":
                System.out.println("Navigating back to the main context.");
                break;
            default:
                System.out.println("Invalid option. Please enter a valid option.");
        }
    }

    private static void addFile(String fileName) {
        try {
            File file = new File(ROOT_DIR, fileName);
            boolean isCreated = file.createNewFile();
            if (isCreated) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    private static void deleteFile(String fileName) {
        File file = new File(ROOT_DIR, fileName);
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("FNF (File Not Found). Please enter a valid file name.");
        }
    }

    private static void searchFile(String fileName) {
        File file = new File(ROOT_DIR, fileName);
        if (file.exists()) {
            System.out.println("File found: " + file.getName());
        } else {
            System.out.println("FNF (File Not Found). Please enter a valid file name.");
        }
    }
}
    
    