package ub.csi142.studygroupscheduler.contracts;

public interface Schedulable {

    /** Print full details about this object to the console. */
    void displayInfo();

     /** Return a one-line summary string of this object. */
    String getSummary();
}