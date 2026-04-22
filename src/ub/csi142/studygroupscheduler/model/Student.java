package ub.csi142.studygroupscheduler.model;

public class Student {
    //TODO: Fields and methods - Milestone 3
    private String studentID;
    private String fullName;
    private String email;

    public Student(String studentID, String fullName, String email) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.email = email;
    }

    public String getstudentID() {
        return studentID;
    }

    public String getfullname() {
        return fullName;
    }    

    public String getemail() {
        return email;
    }

    public static void main(String[] args) {
        Student s = new
    Student("202507533", "Karabo Machola", "Machola@ub.ac.bw");

    System.out.println("--- Student Test ---");
    System.out.println("ID: " + s.getstudentID());
    System.out.println("Name: " + s.getfullname());
    System.out.println("Email: " + s.getemail());

    }

    public void setstudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public void setemail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + fullName;
    }
}
