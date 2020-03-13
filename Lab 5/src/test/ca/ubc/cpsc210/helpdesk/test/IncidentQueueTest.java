package ca.ubc.cpsc210.helpdesk.test;

import ca.ubc.cpsc210.helpdesk.model.Incident;
import ca.ubc.cpsc210.helpdesk.model.IncidentQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class IncidentQueueTest {
    // Design your unit tests for the IncidentQueue class here
    IncidentQueue testQueue;
    Incident incidentExample1 = new Incident(10, "");
    Incident incidentExample2 = new Incident(20, "");

    @BeforeEach
    public void setUp() {
        testQueue = new IncidentQueue();

    }

    @Test
    public void addIncidentNotFullTest() {
        assertFalse(testQueue.isFull());
        assertTrue(testQueue.addIncident(incidentExample1));
    }

    @Test
    public void addIncidentFullTest() {
        int i;
        //Adds ten incidents into queue to make full
        for(i = 0; i < 10; i++){
            testQueue.addIncident(incidentExample1);
        }
        assertTrue(testQueue.isFull());
        assertFalse(testQueue.addIncident(incidentExample1));
    }

    @Test
    public void getNextIncidentTest() {
        //First in -> First out
        //incidentExample1 should be returned
        testQueue.addIncident(incidentExample1);
        testQueue.addIncident(incidentExample2);
        testQueue.addIncident(incidentExample2);
        testQueue.addIncident(incidentExample2);
        assertEquals(incidentExample1, testQueue.getNextIncident());
    }

    @Test
    public void lengthTest() {
        testQueue.addIncident(incidentExample1);
        testQueue.addIncident(incidentExample2);
        testQueue.addIncident(incidentExample2);
        testQueue.addIncident(incidentExample2);
        assertEquals(4, testQueue.length());
    }

    @Test
    public void isEmptyTest() {
        //Note the queue starts empty
        assertTrue(testQueue.isEmpty());

        //Testing when it has something in it
        testQueue.addIncident(incidentExample1);
        assertFalse(testQueue.isEmpty());
    }

    @Test
    public void getPositionInQueueOfCaseNumberTest() {
        //Case number is 20
        //Position is 3 for incidentExample2 which has case number 20
        testQueue.addIncident(incidentExample1);
        testQueue.addIncident(incidentExample1);
        testQueue.addIncident(incidentExample2);
        testQueue.addIncident(incidentExample1);
        assertEquals(3, testQueue.getPositionInQueueOfCaseNumber(20));
    }

    @Test
    public void getPositionInQueueOfCaseNumberNotInQueue() {
        //Case number is 30
        //No incident has case number 30
        int i;
        for(i = 0; i < 10; i++){
            testQueue.addIncident(incidentExample1);
        }
        assertEquals(-1, testQueue.getPositionInQueueOfCaseNumber(30));
    }






}