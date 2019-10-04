package com.example.demo.factory;

public class StudentBean {
    String id;
    String name;
    String password;
    String major;
    String grade;
    String email;
    String phone;
    double gpa;
    int choose;
    int finish;
    String rubricId;

    public StudentBean() {

    }

    public StudentBean(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public StudentBean(String id, String name, String password, String major, String grade, String email, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.major = major;
        this.grade = grade;
        this.email = email;
        this.phone = phone;
    }

    public StudentBean(String id, String name, String password, String major, String grade, String email, String phone, double gpa, int choose, int finish, String rubricId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.major = major;
        this.grade = grade;
        this.email = email;
        this.phone = phone;
        this.gpa = gpa;
        this.choose = choose;
        this.finish = finish;
        this.rubricId = rubricId;
    }

    public String getRubricId() {
        return rubricId;
    }

    public void setRubricId(String rubricId) {
        this.rubricId = rubricId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }
}
