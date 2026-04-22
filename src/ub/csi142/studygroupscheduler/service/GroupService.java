package ub.csi142.studygroupscheduler.service;

import ub.csi142.studygroupscheduler.model.*;
import ub.csi142.studygroupscheduler.util.InputHelper;
import java.util.ArrayList;

public class GroupService {
    private ArrayList<StudyGroup> groups = new ArrayList<>();

    public void addGroup(InputHelper input) {
        String name  = input.readString("Enter group name: ");
        String day   = input.readString("Enter meeting day (e.g. Monday): ");
        String start = input.readString("Enter start time (e.g. 08:00): ");
        String end   = input.readString("Enter end time   (e.g. 10:00): ");
        TimeSlot slot = new TimeSlot(day, start, end);
        StudyGroup group = new StudyGroup(name, slot);
        groups.add(group);
        System.out.println("Group '" + name + "' created successfully.");
    }

    public void addStudentToGroup(InputHelper input) {
        if (groups.isEmpty()) {
            System.out.println("No groups exist yet. Create a group first.");
            return;
        }
        listGroupNames();
        int idx = input.readInt("Select group number: ") - 1;
        if (idx < 0 || idx >= groups.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        StudyGroup group = groups.get(idx);
        String id    = input.readString("Student ID  : ");
        String name  = input.readString("Full name   : ");
        String email = input.readString("Email       : ");
        group.addMember(new Student(id, name, email));
        System.out.println("Student added to " + group.getGroupName());
    }

    public void viewAllGroups() {
        if (groups.isEmpty()) {
            System.out.println("No groups found.");
            return;
        }
        System.out.println("\n=== All Study Groups ===");
        for (StudyGroup g : groups) {
            g.displayInfo();
            System.out.println();
        }
    }

    public StudyGroup findGroup(String name) {
        for (StudyGroup g : groups) {
            if (g.getGroupName().equalsIgnoreCase(name)) return g;
        }
        return null;
    }

    public ArrayList<StudyGroup> getGroups() { return groups; }

    private void listGroupNames() {
        System.out.println("--- Groups ---");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println((i + 1) + ". " + groups.get(i).getGroupName());
        }
    }
}