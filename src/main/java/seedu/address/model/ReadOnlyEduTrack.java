package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.module.Class;
import seedu.address.model.student.Student;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyEduTrack {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Student> getStudentList();

    ObservableList<Class> getClassList();
}
