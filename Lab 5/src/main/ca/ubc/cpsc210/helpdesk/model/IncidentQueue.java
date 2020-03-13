package ca.ubc.cpsc210.helpdesk.model;

import java.util.LinkedList;
import java.util.*;


// Represents a queue of incidents to be handled by helpdesk
// with maximum size MAX_SIZE
public class IncidentQueue {
    public static final int MAX_SIZE = 10;
    // TODO: complete the design of the IncidentQueue class
    public LinkedList<Incident> queue;


    //Constructor
    public IncidentQueue() {
        queue = new LinkedList<>();
    }


    //Adds incident to end of queue if not full
    public boolean addIncident(Incident incident) {
        boolean full = this.isFull();
        if (!full) {
            queue.addLast(incident);
            return true;
        } else {
            return false;
        }

    }

    //Removes incident from front of queue
    public Incident getNextIncident() {
        return queue.removeFirst();
    }

    public int getPositionInQueueOfCaseNumber(int caseNumber) {
        int index;
        Incident currentIncident;
        for (index = 0; index < this.length(); index++) {
            currentIncident = queue.get(index);
            if (currentIncident.getCaseNum() == caseNumber) {
                return index + 1;
            }
        }
        return (-1);
    }

    public int length() {
        return queue.size();
    }

    public boolean isEmpty() {
        return (this.length() == 0);
    }

    public boolean isFull() {
        return (this.length() >= MAX_SIZE);
    }




}
