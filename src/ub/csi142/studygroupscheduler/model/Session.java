package ub.csi142.studygroupscheduler.model;

public class Session implements Schedulable {
    private String sessionID;
    private StudyGroup group;
    private TimeSlot slot;
    private String topic;

    public Session(String sessionID, StudyGroup group,
                   TimeSlot slot, String topic) {
        this.sessionID = sessionID;
        this.group = group;
        this.slot = slot;
        this.topic = topic;
    }

    public String getSessionID() { return sessionID; }
    public StudyGroup getGroup() { return group; }
    public TimeSlot getSlot() { return slot; }
    public String getTopic() { return topic; }

    @Override
    public void displayInfo() {
        System.out.println("=== Session: " + sessionID + " ===");
        System.out.println("Group : " + group.getGroupName());
        System.out.println("Topic : " + topic);
        System.out.println("Time  : " + slot.toString());
    }

    @Override
    public String getSummary() {
        return sessionID + " | " + group.getGroupName()
               + " | " + topic + " | " + slot.toString();
    }
}