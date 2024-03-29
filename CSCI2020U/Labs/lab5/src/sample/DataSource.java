package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataSource {
    public static ObservableList<StudentRecord> getAllStudents() {
        ObservableList<StudentRecord> records = FXCollections.observableArrayList();

        // Student ID, Assignments, Midterm, Final exam
        records.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
        records.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
        records.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
        records.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
        records.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
        records.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
        records.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
        records.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
        records.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
        records.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));
        records.add(new StudentRecord("daniyal shah", 74.5f, 87.4f, 75.4f));

        return records;
    }
}