package ub.csi142.studygroupscheduler.model;

import ub.csi142.studygroupscheduler.contracts.Schedulable;
import ub.csi142.studygroupscheduler.exceptions.InvalidInputException;
import java.util.ArrayList;

public class StudyGroup implements Schedulable {

    private String             groupName;
    private String             courseCode;
    private GroupLeader        leader;
    private ArrayList<Student> members;
    private ArrayList<Session> sessions;

    public StudyGroup(String groupName, String courseCode, GroupLeader leader) {
        setGroupName(groupName);
        setCourseCode(courseCode);
        setLeader(leader);
        this.members  = new ArrayList<>();
        this.sessions = new ArrayList<>();
        this.members.add(leader);
    }

    public String             getGroupName()  { return groupName; }
    public String             getCourseCode() { return courseCode; }
    public GroupLeader        getLeader()     { return leader; }
    public ArrayList<Student> getMembers()    { return members; }
    public ArrayList<Session> getSessions()   { return sessions; }

    public void setGroupName(String groupName) {
        if (groupName == null || groupName.trim().isEmpty())
            throw new InvalidInputException("Group name cannot be blank.");
        this.groupName = groupName.trim();
    }

    public void setCourseCode(String code) {
        if (code == null || code.trim().isEmpty())
            throw new InvalidInputException("Course code cannot be blank.");
        this.courseCode = code.trim().toUpperCase();
    }

    public void setLeader(GroupLeader leader) {
        if (leader == null)
            throw new InvalidInputException("Group leader cannot be null.");
        this.leader = leader;
    }

    public boolean addMember(Student student) {
        for (Student s : members) {
            if (s.getStudentId().equals(student.getStudentId())) return false;
        }
        members.add(student);
        return true;
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public int countUpcoming() {
        int n = 0;
        for (Session s : sessions) if (s.isScheduled()) n++;
        return n;
    }

    @Override
    public void displayInfo() {
        System.out.println("  Group    : " + groupName);
        System.out.println("  Course   : " + courseCode);
        System.out.println("  Leader   : " + leader.getFullName() + " [" + leader.getStudentId() + "]");
        System.out.println("  Members  : " + members.size());
        System.out.println("  Sessions : " + sessions.size() + " total, " + countUpcoming() + " upcoming");
    }

    @Override
    public String getSummary() {
        return groupName + " | " + courseCode
               + " | Leader: " + leader.getFullName()
               + " | Members: " + members.size()
               + " | Sessions: " + sessions.size();
    }

    @Override
    public String toString() { return getSummary(); }
}