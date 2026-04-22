package ub.csi142.studygroupscheduler.app;

import ub.csi142.studygroupscheduler.service.GroupService;
import ub.csi142.studygroupscheduler.service.ScheduleService;
import ub.csi142.studygroupscheduler.util.InputHelper;
import ub.csi142.studygroupscheduler.model.*;

public class MainApp {

    public static void main(String[] args) {

        GroupService groupService = new GroupService();
        ScheduleService scheduleService = new ScheduleService();
        InputHelper input = new InputHelper();

        StudyGroup g1 = new StudyGroup("OOP Squad",
                new TimeSlot("Monday", "08:00", "10:00"));
        g1.addMember(new Student("202507533", "Karabo Machola",
                "machola@ub.ac.bw"));
        g1.addMember(new Student("202508890", "Thabo Kgosi",
                "kgosi@ub.ac.bw"));
        groupService.getGroups().add(g1);

        int choice;
        do {
            System.out.println("\n=== Study Group Scheduler ===");
            System.out.println("1. Create group");
            System.out.println("2. Add student to group");
            System.out.println("3. Schedule session");
            System.out.println("4. View all groups");
            System.out.println("5. View sessions for a group");
            System.out.println("6. View all sessions");
            System.out.println("0. Exit");

            choice = input.readInt("Enter choice: ");

            switch (choice) {
                case 1 -> groupService.addGroup(input);
                case 2 -> groupService.addStudentToGroup(input);
                case 3 -> scheduleService.scheduleSession(input, groupService);
                case 4 -> groupService.viewAllGroups();
                case 5 -> scheduleService.viewSessionsForGroup(input, groupService);
                case 6 -> scheduleService.viewAllSessions();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);

        input.close();
    }
}





