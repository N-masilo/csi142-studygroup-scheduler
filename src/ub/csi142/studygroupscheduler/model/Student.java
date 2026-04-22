package ub.csi142.studygroupscheduler.model;

public class Student {
    private String studentID;
    private String fullName;
    private String email;

    public Student(String studentID, String fullName, String email) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.email = email;
    }

    public String getStudentID() { return studentID; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return fullName + " (" + studentID + ") - " + email;
    }
}