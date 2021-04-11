package ru.shkolaandstudents.LoginAndRegist;

public class User {

    public String LastName, FirstName, Otchest, email, str_class;

    public boolean teacher;


    public User()
    {

    }

    public User(String LastName, String FirstName, String Otchest, String email, boolean teacher, String str_class)
    {
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Otchest = Otchest;
        this.email = email;
        this.teacher = teacher;
        this.str_class = str_class;
    }

    public boolean isTeacher() {
        return teacher;
    }
}
