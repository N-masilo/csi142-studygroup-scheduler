package ub.csi142.studygroupscheduler.model;

import java.util.ArrayList;
import java.util.List;

class StudySession {
    String subject;
    int duration;

    public StudySession(String subject, int duration) {
        this.subject = subject;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return subject + " - " + duration + " min";
    }
}

public class StudyPlanner {

    public static void allocateSessions(List<StudySession> sessions, int maxSessionTime) {

        int currentTime = 0;
        int sessionNumber = 1;

        System.out.println("Study Plan:\n");

        for (StudySession s : sessions) {

            if (currentTime + s.duration > maxSessionTime) {
                sessionNumber++;
                currentTime = 0;
                System.out.println("\n--- Session " + sessionNumber + " ---");
            }

            if (currentTime == 0) {
                System.out.println("--- Session " + sessionNumber + " ---");
            }

            System.out.println(s);
            currentTime += s.duration;
        }
    }

    public static void main(String[] args) {

        List<StudySession> sessions = new ArrayList<>();

        sessions.add(new StudySession("Math", 45));
        sessions.add(new StudySession("Physics", 60));
        sessions.add(new StudySession("Chemistry", 60));
        sessions.add(new StudySession("Biology", 30));

        int maxSessionTime = 120;

        allocateSessions(sessions, maxSessionTime);
    }
}