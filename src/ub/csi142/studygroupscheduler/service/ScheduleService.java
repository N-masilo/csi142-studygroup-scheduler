package ub.csi142.studygroupscheduler.service;

import java.util.ArrayList;
import java.util.List;
import ub.csi142.studygroupscheduler.exceptions.GroupNotFoundException;
import ub.csi142.studygroupscheduler.model.Session;
import ub.csi142.studygroupscheduler.model.StudyGroup;
import ub.csi142.studygroupscheduler.model.TimeSlot;
import ub.csi142.studygroupscheduler.util.InputHelper;

public class ScheduleService {

    private List<Session> sessions = new ArrayList<>();

    public void scheduleSession(InputHelper input, GroupService groupService) {
        System.out.println("\n--- Schedule a New Session ---");

        try {
            String groupName = input.readString("Enter the Study Group Name: ");

            StudyGroup group = groupService.findGroupbyName(groupName);

            String time = input.readString("Enter day and time(e.g. Friday 14:00): ");
            TimeSlot slot = new TimeSlot(time);

            Session newSession = new Session(group, slot);
            sessions.add(newSession);

            System.out.println("Success: Session scheduled for " + groupName);

        } catch (GroupNotFoundException e) {

            System.out.println("Error: " e.getMessage());
        }
    }

    public void viewSessionsForGroup(InputHelper input, GroupService groupService) {

        String groupName = input.readString("Enter group name to filter by: ");
        boolean found = false

        System.out.println("\n--- Sessions for " + groupName + " ---");

        for (Session s : sessions) {

            if (s.getGroup().getName().equalsIgnoreCase(groupName)) {

                System.out.println(s);
                found = true
                
            }
        }

        if (!found) {
            System.out.println("No sessions currently scheduled for this group.");
        }
    }

    public void viewAllSessions() {
        System.out.println("\n--- All Scheduled Sessions ---");

        if (sessions.isEmpty()) {
            System.out.println("The schedule is currently empty.");
        } else {
            for (Session s : sessions) {

                System.out.println(s);
            }
        }
    }
}