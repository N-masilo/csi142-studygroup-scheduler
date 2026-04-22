package ub.csi142.studygroupscheduler.app;

import ub.csi142.studygroupscheduler.service.GroupService;
import ub.csi142.studygroupscheduler.service.ScheduleService;
import ub.csi142.studygroupscheduler.util.InputHelper;

public class MainApp {

     public static void main(String[] args) {

        GroupService groupService = new GroupService();
        ScheduleService scheduleService = new ScheduleService();
        InputHelper input = new InputHelper();

        int choice;

        do{
            System.out.println("\n=== Study Group Scheduler ===");
            System.out.println("1. Create group");
            System.out.println("2. Add student");
            System.out.println("3. Schedule session");
            System.out.println("4. View groups");
            System.out.println("5. View group sessions");
            System.out.println("6. View all sessions");
            System.out.println("0. Exit");

            choice = input.readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    groupService.addGroup(input);
                    break;
                case 2:
                    groupService.addStudentToGroup(input);
                    break;
                case 3:
                    scheduleService.scheduleSession(input, groupService);
                    break;
                case 4:
                    groupService.viewAllGroups();
                    break;
                 case 5:
                    scheduleService.viewSessionsForGroup(input, groupService);
                    break;
                case 6:
                    scheduleService.viewAllSessions();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");

            }

        } while (choice != 0);

        input.close();
    }
}    





