package vn.codegym.model;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private int gender;
    private String[] language;

    public Student() {
    }

    public Student(int id, String name, int gender, String[] language) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.language = language;
    }

    public Student(String name, int gender, String[] language) {
        this.name = name;
        this.gender = gender;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public String[] getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", language=" + Arrays.toString(language) +
                '}';
    }
}
