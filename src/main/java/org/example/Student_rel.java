package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student_rel {
    @Id
    private int rollNo;
    private String name;
    private int marks;

    @OneToMany(mappedBy = "student")
    private List<Laptop_rel> laptops = new ArrayList<>();
    public int getMarks() {
        return marks;
    }

    public List<Laptop_rel> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop_rel> laptops) {
        this.laptops = laptops;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student_rel{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
