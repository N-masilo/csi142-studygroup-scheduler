package ub.csi142.studygroupscheduler.model;

import java.util.ArrayList;
 
 public class StudyGroup {
    private String groupName;
    private ArrayList<Student> members; 
    private Timeslot slot; 

    public StudyGroup(String groupName,Timeslot slot) {
        this.groupName = groupName;
        this.slot = slot;
        this.members = new ArrayList<>();
    }

    public void addMember(Student student) {
        if (student != null) {
            members.add(student);
        }
    }

    public String getGroupName() {
        return groupName;
    }

    public ArrayList<Student> getMembers() {
        return members;
    }

    public Timeslot getSlot() {
        return slot;
    }

    public void displayGroupInfo() {
        System.out.println("--- Study Group: " + groupName + " ---");
        System.out.println("Time: " + slot.getStartTime() + " to " + 
        slot.getEndTime());
        System.out.println("Members: ");
        for (Student s : members) {
            System.out.println("-" + s.getfullname() + 
            "(" + s.getstudentID() +")");
        }
    }

 }