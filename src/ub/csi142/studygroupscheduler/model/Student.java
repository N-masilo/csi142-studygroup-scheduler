package ub.csi142.studygroupscheduler.model;

import ub.csi142.studygroupscheduler.exceptions.InvalidInputException;

public class Student extends Person {

    private String programme;
    private int    yearOfStudy;

    public Student(String studentId, String fullName, String email,
                   String programme, int yearOfStudy) {
        super(studentId, fullName, email);
        setProgramme(programme);
        setYearOfStudy(yearOfStudy);
    }

    public Student(String studentId, String fullName, String email, String programme) {
        this(studentId, fullName, email, programme, 1);
    }

    public String getProgramme()   { return programme; }
    public int    getYearOfStudy() { return yearOfStudy; }

    public void setProgramme(String programme) {
        if (programme == null || programme.trim().isEmpty())
            throw new InvalidInputException("Programme cannot be blank.");
        this.programme = programme.trim();
    }

    public void setYearOfStudy(int year) {
        if (year < 1 || year > 4)
            throw new InvalidInputException("Year of study must be between 1 and 4.");
        this.yearOfStudy = year;
    }

    @Override
    public String getRole() { return "Student"; }

    @Override
    public String toString() {
        return "[" + getStudentId() + "] " + getFullName()
               + " | " + programme + " Year " + yearOfStudy
               + " (" + getRole() + ")";
    }
}
