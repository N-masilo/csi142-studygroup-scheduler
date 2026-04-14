package ub.csi142.studygroupscheduler.service;

import ub.csi142.studygroupscheduler.util.InputHelper;

public class ScheduleService {

    public void scheduleSession(InputHelper input, GroupService groupService) {
        System.out.println("Scheduling session...");
    }

    public void viewSessionsForGroup(InputHelper input, GroupService groupService) {
        System.out.println("Viewing sessions for a group...");
    }

    public void viewAllSessions() {
        System.out.println("Displaying all sessions...");
    }
}