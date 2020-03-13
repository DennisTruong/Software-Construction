package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {
    private Bus testBus;
    private Student blossom;
    private Student bubbles;
    private Student buttercup;

    private Chaperone testChaperone;

    @BeforeEach
    public void setUp() {
        testBus = new Bus(100, 3);
        blossom = new Student(1, "Blossom", 4);
        bubbles = new Student(2, "Bubbles", 4);
        buttercup = new Student(3, "Buttercup", 4);
        testChaperone = new Chaperone("Professor Utonium");
    }

    @Test
    public void constructorTests() {
        assertEquals(100, testBus.getId());
        assertEquals(3, testBus.getCapacity());
        assertEquals(0, testBus.getStudents().size());
        assertFalse(testBus.isFull());
    }

    @Test
    public void chaperoneTests() {
        assertFalse(testBus.hasChaperone());
        assertNull(testBus.getChaperone());
        testBus.setChaperone(testChaperone);
        assertTrue(testBus.hasChaperone());
        assertEquals(testChaperone, testBus.getChaperone());
        assertEquals(testChaperone.getName(), "Professor Utonium");
    }

    @Test
    public void addStudentsTest() {
        assertFalse(testBus.isFull());
        testBus.addStudent(blossom);
        assertEquals(1,testBus.getStudents().size());
        testBus.addStudent(blossom);
        assertEquals(1,testBus.getStudents().size());
        testBus.addStudent(bubbles);
        testBus.addStudent(buttercup);
        assertEquals(3,testBus.getStudents().size());
        assertTrue(testBus.isFull());

        System.out.println(testBus.getStudents());
    }

    @Test
    public void removeStudentTest() {
        testBus.addStudent(blossom);
        testBus.addStudent(bubbles);
        testBus.addStudent(buttercup);
        assertEquals(3, testBus.getStudents().size());
        testBus.removeStudent(blossom);
        assertEquals(2, testBus.getStudents().size());
        assertNull(blossom.getAssignedBus());
    }

    @Test
    public void switchBusTest() {
        Bus secondBus = new Bus(101, 2);
        testBus.addStudent(blossom);
        testBus.addStudent(bubbles);
        testBus.addStudent(buttercup);
        assertEquals(3, testBus.getStudents().size());

        assertEquals(0, secondBus.getStudents().size());
        secondBus.addStudent(buttercup);
        assertEquals(1, secondBus.getStudents().size());

        assertEquals(2, testBus.getStudents().size());

        System.out.println(testBus.getStudents());
        System.out.println(secondBus.getStudents());

        System.out.println(buttercup.getAssignedBus().getId());
        System.out.println(blossom.getAssignedBus().getId());

    }



}