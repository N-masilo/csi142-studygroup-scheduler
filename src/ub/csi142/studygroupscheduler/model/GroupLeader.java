package ub.csi142.studygroupscheduler.model;

public class GroupLeader extends Student {

    private String leadershipNote;

    public GroupLeader(String studentId, String fullName, String email,
                       String programme, int yearOfStudy, String leadershipNote) {
        super(studentId, fullName, email, programme, yearOfStudy);
        this.leadershipNote = (leadershipNote != null && !leadershipNote.trim().isEmpty())
                ? leadershipNote.trim() : "Group coordinator";
    }

    public GroupLeader(String studentId, String fullName, String email,
                       String programme, int yearOfStudy) {
        this(studentId, fullName, email, programme, yearOfStudy, "Group coordinator");
    }

    public String getLeadershipNote()            { return leadershipNote; }
    public void   setLeadershipNote(String note) { this.leadershipNote = note; }

    @Override
    public String getRole() { return "Group Leader"; }

    @Override
    public String toString() {
        return "[" + getStudentId() + "] " + getFullName()
               + " | " + getProgramme() + " Year " + getYearOfStudy()
               + " (" + getRole() + ")";
    }
}
    

