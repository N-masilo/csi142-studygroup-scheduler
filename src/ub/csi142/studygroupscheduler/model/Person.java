package ub.csi142.studygroupscheduler.model;

import ub.csi142.studygroupscheduler.exceptions.InvalidInputException;

public abstract class Person {

    private String studentId;
    private String fullName;
    private String email;

    public Person(String studentId, String fullName, String email) {
        setStudentId(studentId);
        setFullName(fullName);
        setEmail(email);
    }

    public String getStudentId() { return studentId; }
    public String getFullName()  { return fullName; }
    public String getEmail()     { return email; }

    public void setStudentId(String studentId) {
        if (studentId == null || studentId.trim().isEmpty())
            throw new InvalidInputException("Student ID cannot be blank.");
        this.studentId = studentId.trim().toUpperCase();
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty())
            throw new InvalidInputException("Full name cannot be blank.");
        this.fullName = fullName.trim();
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@"))
            throw new InvalidInputException("Email must contain '@' (e.g. name@ub.ac.bw).");
        this.email = email.trim().toLowerCase();
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return "[" + studentId + "] " + fullName + " (" + getRole() + ")";
    }
}



    

