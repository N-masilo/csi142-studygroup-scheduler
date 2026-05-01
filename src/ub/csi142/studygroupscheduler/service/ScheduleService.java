package ub.csi142.studygroupscheduler.service;

import ub.csi142.studygroupscheduler.contracts.Schedulable;
import ub.csi142.studygroupscheduler.exceptions.GroupNotFoundException;
import ub.csi142.studygroupscheduler.exceptions.InvalidInputException;
import ub.csi142.studygroupscheduler.model.Session;
import ub.csi142.studygroupscheduler.model.StudyGroup;
import ub.csi142.studygroupscheduler.model.TimeSlot;
import ub.csi142.studygroupscheduler.util.InputHelper;
import java.util.ArrayList;

public class ScheduleService {

    private ArrayList<Session> allSessions;
    private int sessionCounter;

    public ScheduleService() {
        this.allSessions    = new ArrayList<>();
        this.sessionCounter = 1;
    }

    public void scheduleSession(InputHelper input, GroupService groupService) {
        System.out.println("\n--- Schedule a Study Session ---");
        try {
            String groupName = input.readString("Group name              : ");
            StudyGroup group = groupService.findGroupByName(groupName);
            String topic = input.readString("Topic                   : ");
            String venue = input.readString("Venue (building + room) : ");
            String day   = input.readString("Day (e.g. Monday)       : ");
            String start = input.readTime  ("Start time (HH:MM)      : ");
            String end   = input.readTime  ("End time   (HH:MM)      : ");
            TimeSlot slot    = new TimeSlot(day, start, end);
            String   id      = "S" + String.format("%03d", sessionCounter++);
            Session  session = new Session(id, topic, venue, slot, groupName);
            group.addSession(session);
            allSessions.add(session);
            System.out.println("\n[OK] Session " + id + " scheduled for '" + groupName + "'.");
        } catch (GroupNotFoundException | InvalidInputException e) {
            System.out.println("\n[ERROR] " + e.getMessage());
        }
    }

    public void viewSessionsForGroup(InputHelper input, GroupService groupService) {
        System.out.println("\n--- Sessions for a Group ---");
        try {
            String     groupName = input.readString("Group name: ");
            StudyGroup group     = groupService.findGroupByName(groupName);
            if (group.getSessions().isEmpty()) {
                System.out.println("No sessions scheduled for '" + groupName + "' yet.");
                return;
            }
            System.out.println("\nSessions for '" + groupName + "':");
            for (Schedulable s : group.getSessions()) {
                System.out.println("  " + s.getSummary());
            }
        } catch (GroupNotFoundException e) {
            System.out.println("\n[ERROR] " + e.getMessage());
        }
    }

    public void viewAllSessions() {
        System.out.println("\n--- All Sessions ---");
        if (allSessions.isEmpty()) { System.out.println("No sessions scheduled yet."); return; }
        for (Schedulable s : allSessions) {
            System.out.println();
            s.displayInfo();
        }
        System.out.println("\nTotal: " + allSessions.size() + " session(s).");
    }

    public void updateSessionStatus(InputHelper input) {
        System.out.println("\n--- Update Session Status ---");
        if (allSessions.isEmpty()) { System.out.println("No sessions exist yet."); return; }
        System.out.println("Existing sessions:");
        for (Session s : allSessions) System.out.println("  " + s.getSummary());
        try {
            String  id     = input.readString("Session ID to update: ").toUpperCase();
            Session target = null;
            for (Session s : allSessions) {
                if (s.getSessionId().equals(id)) { target = s; break; }
            }
            if (target == null) { System.out.println("[!] Session '" + id + "' not found."); return; }
            System.out.println("1. Mark as Completed");
            System.out.println("2. Mark as Cancelled");
            int choice = input.readIntInRange("Choice: ", 1, 2);
            target.setStatus(choice == 1 ? "Completed" : "Cancelled");
            System.out.println("[OK] Session " + id + " marked as " + target.getStatus() + ".");
        } catch (InvalidInputException e) {
            System.out.println("\n[ERROR] " + e.getMessage());
        }
    }
}