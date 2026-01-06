package com.skillnext2;

public class Student {

    private int id;
    private int sem;
    private String department;

    // No-arg constructor
    public Student() {
    }

    // Constructor without id (for insert)
    public Student(int sem, String department) {
        this.sem = sem;
        this.department = department;
    }

    // Constructor with id (for update)
    public Student(int id, int sem, String department) {
        this.id = id;
        this.sem = sem;
        this.department = department;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
