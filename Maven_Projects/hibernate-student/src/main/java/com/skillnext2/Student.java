package com.skillnext2;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int sem;

    private String department;

    public Student() {}

    public Student(int sem, String department) {
        this.sem = sem;
        this.department = department;
    }

    // Getters & Setters
    public int getId() {
        return id;
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