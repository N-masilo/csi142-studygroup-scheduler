package ub.csi142.studygroupscheduler.app;


import ub.csi142.studygroupscheduler.service.GroupService;
import ub.csi142.studygroupscheduler.service.ScheduleService;
import ub.csi142.studygroupscheduler.util.InputHelper;

public class MainApp {

    public static void main(String[] args) {

        GroupService    groupService    = new GroupService();
        ScheduleService scheduleService = new ScheduleService();
        InputHelper     input           = new InputHelper();

        System.out.println("==============================================");
        System.out.println("   UB Study-Group Scheduler  |  CSI142");
        System.out.println("   University of Botswana, Gaborone");
        System.out.println("==============================================");
        System.out.println("  2 groups pre-loaded. Type 4 to see them.");

        int choice;

        do {
            System.out.println("\n============= MAIN MENU =============");
            System.out.println("  1.  Create a study group");
            System.out.println("  2.  Add student to a group");
            System.out.println("  3.  Schedule a session");
            System.out.println("  4.  View all groups");
            System.out.println("  5.  View sessions for a group");
            System.out.println("  6.  View all sessions");
            System.out.println("  7.  Update session status");
            System.out.println("  8.  Search groups by course code");
            System.out.println("  9.  View group members");
            System.out.println("  10. Print groups report");
            System.out.println("  0.  Exit");
            System.out.println("=====================================");

            choice = input.readInt("Enter choice: ");

            switch (choice) {
                case 1:  groupService.addGroup(input);                              break;
                case 2:  groupService.addStudentToGroup(input);                     break;
                case 3:  scheduleService.scheduleSession(input, groupService);      break;
                case 4:  groupService.viewAllGroups();                              break;
                case 5:  scheduleService.viewSessionsForGroup(input, groupService); break;
                case 6:  scheduleService.viewAllSessions();                         break;
                case 7:  scheduleService.updateSessionStatus(input);                break;
                case 8:  groupService.searchByCourse(input);                        break;
                case 9:  groupService.viewGroupMembers(input);                      break;
                case 10: groupService.printReport();                                break;
                case 0:  System.out.println("\nGoodbye! Sala sentle.");             break;
                default: System.out.println("[!] Invalid choice. Enter 0 to 10.");
            }

        } while (choice != 0);

        input.close();
    }
}





