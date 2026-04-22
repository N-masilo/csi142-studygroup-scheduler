package ub.csi142.studygroupscheduler.model;

import java.util.ArrayList;

public class StudyGroup implements Schedulable {
    private String groupName;
    private ArrayList<Student> members;
    private TimeSlot slot;

    public StudyGroup(String groupName, TimeSlot slot) {
        this.groupName = groupName;
        this.slot = slot;
        this.members = new ArrayList<>();
    }

    // Constructor overloading (no slot version)
    public StudyGroup(String groupName) {
        this(groupName, null);
    }

    public void addMember(Student student) {
        if (student != null) members.add(student);
    }

    public String getGroupName() { return groupName; }
    public ArrayList<Student> getMembers() { return members; }
    public TimeSlot getSlot() { return slot; }
    public void setSlot(TimeSlot slot) { this.slot = slot; }

    @Override
    public void displayInfo() {
        System.out.println("=== Study Group: " + groupName + " ===");
        if (slot != null)
            System.out.println("Time: " + slot.toString());
        System.out.println("Members (" + members.size() + "):");
        for (Student s : members) {
            System.out.println("  - " + s.getFullName()
                               + " (" + s.getStudentID() + ")");
        }
    }

    @Override
    public String getSummary() {
        return groupName + " | Members: " + members.size()
               + (slot != null ? " | " + slot.toString() : "");
    }
}