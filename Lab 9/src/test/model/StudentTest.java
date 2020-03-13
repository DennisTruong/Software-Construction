package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Bus testBus;
    private Student blossom;
    private Student bubbles;
    private Student buttercup;


    @BeforeEach
    public void setUp() {
        testBus = new Bus(100, 3);
        blossom = new Student(1, "Blossom", 4);
        bubbles = new Student(2, "Bubbles", 4);
        buttercup = new Student(3, "Buttercup", 4);
    }

    @Test
    public void constructorTest() {
        assertEquals("Blossom", blossom.getName());
        assertEquals(4,blossom.getGrade());
        assertEquals(1, blossom.getId());
        assertNull(blossom.getAssignedBus());

        assertFalse(blossom.isAssignedToBus());
    }

    @Test
    public void assignToBusTest() {
        assertNull(blossom.getAssignedBus());
        assertFalse(blossom.isAssignedToBus());
        blossom.assignToBus(testBus);
        assertNotNull(blossom.getAssignedBus());
        assertEquals(testBus, blossom.getAssignedBus());

        assertEquals(1, testBus.getStudents().size());
        blossom.assignToBus(testBus);
        assertNotNull(blossom.getAssignedBus());
        assertEquals(testBus, blossom.getAssignedBus());

        assertEquals(1, testBus.getStudents().size());
    }

    @Test
    public void removeFromBusTest() {
        assertNull(blossom.getAssignedBus());
        assertFalse(blossom.isAssignedToBus());
        blossom.assignToBus(testBus);
        assertNotNull(blossom.getAssignedBus());
        assertEquals(testBus, blossom.getAssignedBus());
        blossom.removeFromBus();
        assertNull(blossom.getAssignedBus());
        assertFalse(blossom.isAssignedToBus());

    }

}

