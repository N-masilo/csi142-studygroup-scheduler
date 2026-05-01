package ub.csi142.studygroupscheduler.model;


public class TimeSlot {

    private String day;
    private String startTime;
    private String endTime;

    public TimeSlot(String day, String startTime, String endTime) {
        this.day       = day;
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public String getDay()       { return day; }
    public String getStartTime() { return startTime; }
    public String getEndTime()   { return endTime; }

    @Override
    public String toString() {
        return day + " " + startTime + " to " + endTime;
    }
}   