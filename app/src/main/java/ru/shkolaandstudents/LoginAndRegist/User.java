package ru.shkolaandstudents.LoginAndRegist;

public class User {

    public String fullName, age, email;

    public boolean teacher;


    public User()
    {

    }

    public User(String fullName, String age, String email, boolean teacher)
    {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.teacher = teacher;
    }

    public boolean isTeacher() {
        return teacher;
    }
}
