package com.skillnext2;

public class Student {
    private int id;
    private int sem;
    private String department;

    // Constructors
    public Student() {}

    public Student(int sem, String department) {
        this.sem = sem;
        this.department = department;
    }

    // Getters and setters
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

    @Override
    public String toString() {
        return "Student [id=" + id + ", sem=" + sem + ", department=" + department + "]";
    }
}