package ub.csi142.studygroupscheduler.service;

import ub.csi142.studygroupscheduler.contracts.Schedulable;
import ub.csi142.studygroupscheduler.exceptions.GroupNotFoundException;
import ub.csi142.studygroupscheduler.exceptions.InvalidInputException;
import ub.csi142.studygroupscheduler.model.GroupLeader;
import ub.csi142.studygroupscheduler.model.Student;
import ub.csi142.studygroupscheduler.model.StudyGroup;
import ub.csi142.studygroupscheduler.util.InputHelper;
import java.util.ArrayList;

public class GroupService {

    private ArrayList<StudyGroup> groups;

    public GroupService() {
        this.groups = new ArrayList<>();
        loadSeedData();
    }

    private void loadSeedData() {
        GroupLeader leader1 = new GroupLeader("202502164", "Naledi Masilo",
                "n.masilo@ub.ac.bw", "BSc Computer Science", 1, "Schedules sessions and keeps notes");
        StudyGroup g1 = new StudyGroup("CSI142 Study Group A", "CSI142", leader1);
        g1.addMember(new Student("202302038", "Keith Wallace",     "k.wallace@ub.ac.bw",  "BSc Computer Science", 1));
        g1.addMember(new Student("202502328", "Moagisi Ramatlae", "m.ramatlae@ub.ac.bw", "BSc Computer Science", 1));
        groups.add(g1);

        GroupLeader leader2 = new GroupLeader("202405408", "Thuto Thapo",
                "t.thapo@ub.ac.bw", "BSc Mathematics", 1);
        StudyGroup g2 = new StudyGroup("MAT111 Calculus Group", "MAT111", leader2);
        g2.addMember(new Student("2023506511", "Loago Amogelang", "l.amogelang@ub.ac.bw", "BSc Mathematics", 2));
        groups.add(g2);
    }

    public void addGroup(InputHelper input) {
        System.out.println("\n--- Create New Study Group ---");
        try {
            String name   = input.readString("Group name        : ");
            String course = input.readString("Course code       : ");
            System.out.println("  (Enter leader details)");
            String lId    = input.readString("Leader student ID : ");
            String lName  = input.readString("Leader full name  : ");
            String lEmail = input.readString("Leader email      : ");
            String lProg  = input.readString("Leader programme  : ");
            int    lYear  = input.readIntInRange("Leader year (1-4) : ", 1, 4);
            GroupLeader leader = new GroupLeader(lId, lName, lEmail, lProg, lYear);
            groups.add(new StudyGroup(name, course, leader));
            System.out.println("\n[OK] Group '" + name + "' created. Leader: " + lName);
        } catch (InvalidInputException e) {
            System.out.println("\n[ERROR] " + e.getMessage());
        }
    }

    public void addStudentToGroup(InputHelper input) {
        System.out.println("\n--- Add Student to Group ---");
        if (groups.isEmpty()) { System.out.println("No groups yet. Create one first."); return; }
        try {
            String groupName = input.readString("Group name   : ");
            StudyGroup group = findGroupByName(groupName);
            String sId    = input.readString("Student ID   : ");
            String sName  = input.readString("Full name    : ");
            String sEmail = input.readString("Email        : ");
            String sProg  = input.readString("Programme    : ");
            int    sYear  = input.readIntInRange("Year (1-4)   : ", 1, 4);
            Student student = new Student(sId, sName, sEmail, sProg, sYear);
            boolean added   = group.addMember(student);
            if (added) System.out.println("\n[OK] " + sName + " added to '" + groupName + "'.");
            else       System.out.println("\n[!] Student " + sId + " is already in this group.");
        } catch (GroupNotFoundException | InvalidInputException e) {
            System.out.println("\n[ERROR] " + e.getMessage());
        }
    }

    public void viewAllGroups() {
        System.out.println("\n--- All Study Groups ---");
        if (groups.isEmpty()) { System.out.println("No groups registered yet."); return; }
        int i = 1;
        for (StudyGroup g : groups) {
            System.out.println("\nGroup " + i++ + ":");
            g.displayInfo();
        }
    }

    public void searchByCourse(InputHelper input) {
        System.out.println("\n--- Search by Course Code ---");
        String code = input.readString("Course code (e.g. CSI142): ").toUpperCase();
        boolean found = false;
        for (StudyGroup g : groups) {
            if (g.getCourseCode().equals(code)) {
                System.out.println("  " + g.getSummary());
                found = true;
            }
        }
        if (!found) System.out.println("No groups found for: " + code);
    }

    public void viewGroupMembers(InputHelper input) {
        System.out.println("\n--- View Group Members ---");
        if (groups.isEmpty()) { System.out.println("No groups yet."); return; }
        try {
            String groupName = input.readString("Group name: ");
            StudyGroup group = findGroupByName(groupName);
            System.out.println("\nMembers of '" + group.getGroupName() + "':");
            for (Student s : group.getMembers()) {
                System.out.println("  " + s);
            }
        } catch (GroupNotFoundException e) {
            System.out.println("\n[ERROR] " + e.getMessage());
        }
    }

    public void printReport() {
        System.out.println("\n========== GROUPS REPORT ==========");
        if (groups.isEmpty()) { System.out.println("No groups to report on."); return; }
        for (Schedulable item : groups) {
            System.out.println("  " + item.getSummary());
        }
        System.out.println("  Total groups: " + groups.size());
        System.out.println("====================================");
    }

    public StudyGroup findGroupByName(String name) {
        for (StudyGroup g : groups) {
            if (g.getGroupName().equalsIgnoreCase(name)) return g;
        }
        throw new GroupNotFoundException(name);
    }

    public ArrayList<StudyGroup> getGroups() { return groups; }
}