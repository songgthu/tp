package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.EduTrack;
import seedu.address.model.common.Memo;
import seedu.address.model.module.Class;
import seedu.address.model.module.ClassName;
import seedu.address.model.module.Schedule;
import seedu.address.model.student.UniqueStudentList;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalClasses {
    private static final String EMPTY_MEMO = " ";
    public static final Class CS2102 = new Class(new ClassName("cs2102"), new UniqueStudentList(),
            new Memo(EMPTY_MEMO), new Schedule());
    public static final Class CS2105 = new Class(new ClassName("cs2105"), new UniqueStudentList(),
            new Memo(EMPTY_MEMO), new Schedule());
    public static final Class CS2040 = new Class(new ClassName("cs2040"), new UniqueStudentList(),
            new Memo(EMPTY_MEMO), new Schedule());

    private TypicalClasses() {} // prevents instantiation

    /**
     * Returns an {@code EduTrack} with all the typical persons.
     */
    public static EduTrack getTypicalEduTrack() {
        EduTrack et = new EduTrack();
        for (Class c : getTypicalClasses()) {
            et.addClass(c);
        }
        return et;
    }

    /**
     * returns an {@code EduTrack} with no classes inside.
     */
    public static EduTrack getEmptyEduTrack() {
        return new EduTrack();
    }

    public static List<Class> getTypicalClasses() {
        return new ArrayList<>(Arrays.asList(CS2102, CS2105, CS2040));
    }
}
