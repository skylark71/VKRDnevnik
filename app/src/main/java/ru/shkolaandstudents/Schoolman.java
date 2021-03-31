package ru.shkolaandstudents;

public class Schoolman {
    public String id, name, lastname, school;
    public Integer school_class;

    public Schoolman() {
    }

    public Schoolman(String id, String name, String lastname, String school, Integer school_class) {
        this.name = name;
        this.lastname = lastname;
        this.school = school;
        this.school_class = school_class;
    }
}
