package com.wildcodeschool.example.springHibernateExample.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    public User() {
    }

    public User(String firstName, String lastName, int age, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String firstName;

    private String lastName;
    
    private String description;

    private int age;

    @Override
    public String toString() { 
        return "User [id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", age=" + age + "]";
    }                    

    public Long getId() {
        return id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }    

}