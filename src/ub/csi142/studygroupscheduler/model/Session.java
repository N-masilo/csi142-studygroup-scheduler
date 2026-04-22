import java.util.*;

class StudySession {
    String subject;
    int duration;

    public StudySession(String subject, int duration){
        this.subject = subject;
        this.duration = duration;
    }

    @Override
    public String toString (){
        return subject + "-"+ duration + "mid";
    }
}

public class StudyPlanner {
    public static void allocate Sessions (List <StudySession>sessions, intmaxSessionTime){
        int currentTime = 0;
        int session Number = 1:

        System.out.println ("Study Plan:\n");
        for (StudySession s : sessions){
            if (currentTime + s.duration>maxSessionTime){
                sessionNumber++;
                currentTime = 0;System.out.println("\n---Session"+sessionNumber+"---");

            }

            if (currentTime==0){
                System.out.println("---SessionNumber"+"---");
            }

            System.out.println(s)
            currentTime+=s.duration;
        }
    }

    public static void main (String[]args){
        List<StudySession>sessions=new ArrayList<>();

        sessions.add(new StudySessions("Math",45));
        sessions.add(new StudySessions("Physics",60));
        sessions.add(new StudySessions("Chemistry",60));
        sessions.add(new StudySessions("Biology",30));

        int maxSessionTime=120;

        allocateSessions(sessions, maxSrssionTime);

    }
}