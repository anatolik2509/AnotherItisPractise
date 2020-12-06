package ru.itis.antonov.nio;

import java.util.Date;

public class Student {
    private String name;
    private int sex;
    private Date birthDate;

    public static final int MALE = 0;
    public static final int FEMALE = 1;

    public Student(String name, int sex, Date birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                '}';
    }
}
