package ub.csi142.studygroupscheduler.service;

import ub.csi142.studygroupscheduler.model.*;
import ub.csi142.studygroupscheduler.util.InputHelper;
import java.util.ArrayList;

public class ScheduleService {
    private ArrayList<Session> sessions = new ArrayList<>();
    private int sessionCounter = 1;

    public void scheduleSession(InputHelper input, GroupService groupService) {
        ArrayList<StudyGroup> groups = groupService.getGroups();
        if (groups.isEmpty()) {
            System.out.println("No groups exist. Create a group first.");
            return;
        }
        System.out.println("--- Select group ---");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println((i + 1) + ". " + groups.get(i).getGroupName());
        }
        int idx = input.readInt("Group number: ") - 1;
        if (idx < 0 || idx >= groups.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        StudyGroup group = groups.get(idx);
        String topic = input.readString("Session topic: ");
        String day   = input.readString("Day          : ");
        String start = input.readString("Start time   : ");
        String end   = input.readString("End time     : ");
        TimeSlot slot = new TimeSlot(day, start, end);
        String id = "S" + String.format("%03d", sessionCounter++);
        sessions.add(new Session(id, group, slot, topic));
        System.out.println("Session " + id + " scheduled.");
    }

    public void viewSessionsForGroup(InputHelper input, GroupService groupService) {
        String name = input.readString("Enter group name: ");
        StudyGroup group = groupService.findGroup(name);
        if (group == null) {
            System.out.println("Group not found.");
            return;
        }
        boolean found = false;
        for (Session s : sessions) {
            if (s.getGroup().getGroupName().equalsIgnoreCase(name)) {
                s.displayInfo();
                System.out.println();
                found = true;
            }
        }
        if (!found) System.out.println("No sessions for that group.");
    }

    public void viewAllSessions() {
        if (sessions.isEmpty()) {
            System.out.println("No sessions scheduled yet.");
            return;
        }
        System.out.println("\n=== All Sessions ===");
        for (Schedulable s : sessions) {
            System.out.println(s.getSummary());
        }
    }
}