package com.skillnext2;

import java.util.*;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1: // Add
                        System.out.print("Enter Semester: ");
                        int sem = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        Student s = new Student(sem, dept);
                        dao.addStudent(s);
                        System.out.println("Student Added Successfully!");
                        break;

                    case 2: // Delete
                        System.out.print("Enter Student ID to delete: ");
                        int delId = sc.nextInt();

                        dao.deleteStudent(delId);
                        System.out.println("Student Deleted Successfully!");
                        break;

                    case 3: // Update
                        System.out.print("Enter Student ID: ");
                        int upId = sc.nextInt();

                        System.out.print("Enter New Semester: ");
                        int newSem = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Department: ");
                        String newDept = sc.nextLine();

                        Student upd = new Student();
                        upd.setId(upId);
                        upd.setSem(newSem);
                        upd.setDepartment(newDept);

                        dao.updateStudent(upd);
                        System.out.println("Student Updated Successfully!");
                        break;

                    case 4: // Display
                        List<Student> students = dao.getAllStudents();
                        System.out.println("\n--- Student List ---");
                        for (Student st : students) {
                            System.out.println(st);
                        }
                        break;

                    case 5: // Exit
                        System.out.println("Exiting program...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}