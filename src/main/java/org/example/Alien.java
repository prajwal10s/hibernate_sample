package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "Alien")
public class Alien {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY) // Used to Auto-increment ID
    private int Id;

    @Column(name="Name")
    private String aname;

    @Column(name="Color")
    private String color;

    public Alien(){

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return Id;
    }

    public void setId(int aid) {
        this.Id = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "Id=" + Id +
                ", aname='" + aname + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
