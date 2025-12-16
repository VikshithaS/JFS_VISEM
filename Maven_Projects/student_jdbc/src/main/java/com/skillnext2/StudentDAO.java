package com.skillnext2;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/skillnext2_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234"; // change if needed

    // Add student
    public void addStudent(Student stu) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO student (sem, department) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, stu.getSem());
        stmt.setString(2, stu.getDepartment());
        stmt.executeUpdate();
        conn.close();
    }

    // Fetch all students
    public List<Student> getAllStudents() throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");

        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setSem(rs.getInt("sem"));
            s.setDepartment(rs.getString("department"));
            list.add(s);
        }
        conn.close();
        return list;
    }

    // Delete student
    public void deleteStudent(int id) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "DELETE FROM student WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        conn.close();
    }

    // Update student
    public void updateStudent(Student stu) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "UPDATE student SET sem=?, department=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, stu.getSem());
        stmt.setString(2, stu.getDepartment());
        stmt.setInt(3, stu.getId());
        stmt.executeUpdate();
        conn.close();
    }
}