package com.skillnext2;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    private static final String URL =
        "jdbc:mysql://localhost:3306/skillnext2_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1234"; // change if needed

    // Load MySQL Driver (VERY IMPORTANT)
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Add student
    public void addStudent(Student stu) throws Exception {
        String sql = "INSERT INTO student (sem, department) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, stu.getSem());
            stmt.setString(2, stu.getDepartment());
            stmt.executeUpdate();
        }
    }

    // Fetch all students
    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setSem(rs.getInt("sem"));
                s.setDepartment(rs.getString("department"));
                list.add(s);
            }
        }
        return list;
    }

    // Delete student
    public void deleteStudent(int id) throws Exception {
        String sql = "DELETE FROM student WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Update student
    public void updateStudent(Student stu) throws Exception {
        String sql = "UPDATE student SET sem=?, department=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, stu.getSem());
            stmt.setString(2, stu.getDepartment());
            stmt.setInt(3, stu.getId());
            stmt.executeUpdate();
        }
    }
}
