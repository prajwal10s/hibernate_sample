package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop_rel {
    @Id
    private int lid;
    private String lname;

    @ManyToOne
    private Student_rel student;

    public Student_rel getStudent() {
        return student;
    }

    public void setStudent(Student_rel student) {
        this.student = student;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Laptop_rel{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                '}';
    }
}
