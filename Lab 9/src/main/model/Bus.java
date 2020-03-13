package model;

import java.util.*;

// Represents a bus having an id, capacity, chaperone and set of students assigned to travel on bus
public class Bus {
    private int id;
    private int capacity;

    private Chaperone chaperone;
    private Set<Student> students;

    // EFFECTS: constructs bus with id and capacity
    public Bus(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        students = new HashSet<>();
        chaperone = null;
    }

    public int getId() {
        return this.id;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Chaperone getChaperone() {
        return this.chaperone;
    }

    // EFFECTS: returns true if bus has a chaperone assigned, false otherwise
    public boolean hasChaperone() {
        return chaperone != null;
    }

    // EFFECTS: returns an unmodifiable set of students assigned to travel on this bus
    public Set<Student> getStudents() {
        return this.students;   // stub
    }

    // MODIFIES: this
    // EFFECTS: assigns the chaperone for this bus
    public void setChaperone(Chaperone chaperone) {
        this.chaperone = chaperone;
    }

    // EFFECTS: returns true if bus is full, false otherwise
    public boolean isFull() {
        return students.size() >= capacity;    // stub
    }

    // REQUIRES: !isFull()
    // MODIFIES: this, student
    // EFFECTS: adds student to this bus
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            student.removeFromBus();
            students.add(student);
            student.assignToBus(this);
        }
    }

    // MODIFIES: this, student
    // EFFECTS: removes student from this bus
    public void removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            student.removeFromBus();
        }

    }
}
