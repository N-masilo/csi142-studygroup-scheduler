package ub.csi142.studygroupscheduler.exceptions;

//CUSTOM EXCEPTION — Thrown when a requested study group cannot be located by its name.

public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException(String groupName) {
        super("No group found with name: '" + groupName + "''. Please check the name and try again.");
    }

    
}
g