package ub.csi142.studygroupscheduler.model;

import ub.csi142.studygroupscheduler.contracts.Schedulable;
import ub.csi142.studygroupscheduler.exceptions.InvalidInputException;

public class Session implements Schedulable {

    private String   sessionId;
    private String   topic;
    private String   venue;
    private TimeSlot timeSlot;
    private String   status;
    private String   groupName;

    public Session(String sessionId, String topic, String venue,
                   TimeSlot timeSlot, String groupName) {
        setSessionId(sessionId);
        setTopic(topic);
        setVenue(venue);
        setTimeSlot(timeSlot);
        setGroupName(groupName);
        this.status = "Scheduled";
    }

    public String   getSessionId() { return sessionId; }
    public String   getTopic()     { return topic; }
    public String   getVenue()     { return venue; }
    public TimeSlot getTimeSlot()  { return timeSlot; }
    public String   getStatus()    { return status; }
    public String   getGroupName() { return groupName; }

    public void setSessionId(String id) {
        if (id == null || id.trim().isEmpty())
            throw new InvalidInputException("Session ID cannot be blank.");
        this.sessionId = id.trim().toUpperCase();
    }

    public void setTopic(String topic) {
        if (topic == null || topic.trim().isEmpty())
            throw new InvalidInputException("Topic cannot be blank.");
        this.topic = topic.trim();
    }

    public void setVenue(String venue) {
        if (venue == null || venue.trim().isEmpty())
            throw new InvalidInputException("Venue cannot be blank.");
        this.venue = venue.trim();
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        if (timeSlot == null)
            throw new InvalidInputException("TimeSlot cannot be null.");
        this.timeSlot = timeSlot;
    }

    public void setGroupName(String groupName) {
        if (groupName == null || groupName.trim().isEmpty())
            throw new InvalidInputException("Group name cannot be blank.");
        this.groupName = groupName.trim();
    }

    public void setStatus(String status) {
        if (!status.equals("Scheduled") && !status.equals("Completed") && !status.equals("Cancelled"))
            throw new InvalidInputException("Status must be: Scheduled, Completed, or Cancelled.");
        this.status = status;
    }

    public boolean isScheduled() { return status.equals("Scheduled"); }

    @Override
    public void displayInfo() {
        System.out.println("  Session  : " + sessionId);
        System.out.println("  Group    : " + groupName);
        System.out.println("  Topic    : " + topic);
        System.out.println("  When     : " + timeSlot);
        System.out.println("  Venue    : " + venue);
        System.out.println("  Status   : " + status);
    }

    @Override
    public String getSummary() {
        return "[" + sessionId + "] " + topic + " | " + timeSlot + " | " + venue + " | " + status;
    }

    @Override
    public String toString() { return getSummary(); }
}

    
