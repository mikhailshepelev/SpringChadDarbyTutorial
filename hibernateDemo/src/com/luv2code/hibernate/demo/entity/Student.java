package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "student") //maps this entity to table in DB called student
public class Student {

    @Id //indicate primary key, by default use IDENTITY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY is commonly use in mySQL to auto-increment
    @Column(name="id") //map field to column in DB called id
    private int id;
    //we can set auto-incr starting from given index by running following query:
    //alter table hb_student_tracker.student auto_increment=3000;
    //given value should be less than max value existing
    //counter could be reset by query: truncate hb_student_tracker.student;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
