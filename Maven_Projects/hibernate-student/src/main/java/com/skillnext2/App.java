package com.skillnext2;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Menu =====");
            System.out.println("1. Insert Student");
            System.out.println("2. View Student(s)");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertStudent(sc);
                    break;

                case 2:
                    viewMenu(sc);
                    break;

                case 3:
                    updateStudent(sc);
                    break;

                case 4:
                    deleteStudent(sc);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    // ===== INSERT =====
    private static void insertStudent(Scanner sc) {
        System.out.print("Enter Semester: ");
        int sem = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s = new Student(sem, dept);
        session.persist(s);

        tx.commit();
        session.close();

        System.out.println("Student Inserted Successfully!");
    }

    // ===== VIEW MENU =====
    private static void viewMenu(Scanner sc) {

        System.out.println("\n--- View Options ---");
        System.out.println("1. View Entire Table");
        System.out.println("2. View Particular Student");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();

        if (ch == 1)
            viewAllStudents();
        else if (ch == 2)
            viewStudentById(sc);
        else
            System.out.println("Invalid Option!");
    }

    // ===== VIEW ALL =====
    private static void viewAllStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> list = session.createQuery("from Student", Student.class).list();
        session.close();

        if (list.isEmpty()) {
            System.out.println("No Records Found!");
            return;
        }

        System.out.println("\n===== Student Table =====");
        for (Student s : list) {
            System.out.println("ID: " + s.getId() +
                    " | Sem: " + s.getSem() +
                    " | Dept: " + s.getDepartment());
        }
    }

    // ===== VIEW BY ID =====
    private static void viewStudentById(Scanner sc) {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Student s = session.get(Student.class, id);
        session.close();

        if (s == null) {
            System.out.println("Student Not Found!");
        } else {
            System.out.println("\nStudent Details:");
            System.out.println("ID: " + s.getId());
            System.out.println("Semester: " + s.getSem());
            System.out.println("Department: " + s.getDepartment());
        }
    }

    // ===== UPDATE =====
    private static void updateStudent(Scanner sc) {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Student s = session.get(Student.class, id);

        if (s == null) {
            System.out.println("Student Not Found!");
            session.close();
            return;
        }

        System.out.print("Enter New Semester: ");
        int sem = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter New Department: ");
        String dept = sc.nextLine();

        Transaction tx = session.beginTransaction();
        s.setSem(sem);
        s.setDepartment(dept);
        session.update(s);
        tx.commit();
        session.close();

        System.out.println("Student Updated Successfully!");
    }

    // ===== DELETE =====
    private static void deleteStudent(Scanner sc) {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Student s = session.get(Student.class, id);

        if (s == null) {
            System.out.println("Student Not Found!");
            session.close();
            return;
        }

        Transaction tx = session.beginTransaction();
        session.delete(s);
        tx.commit();
        session.close();

        System.out.println("Student Deleted Successfully!");
    }
}