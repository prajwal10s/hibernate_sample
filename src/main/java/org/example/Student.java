package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Student {
    @Id
    private int Id;
    private StudentName studentName;

    private String rollNo;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public StudentName getStudentName() {
        return studentName;
    }

    public void setStudentName(StudentName studentName) {
        this.studentName = studentName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", studentName=" + studentName +
                ", rollNo='" + rollNo + '\'' +
                '}';
    }
}
