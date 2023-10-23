package seedu.address.model.common;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Class note in EduTrack.
 */

public class Memo {
    public static final String MESSAGE_CONSTRAINTS = "Memo can take any values";

    /*
     * The first character of the note must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "^.*";

    public final String value;

    /**
     * Constructs an {@code Memo}.
     *
     * @param note A valid note.
     */
    public Memo(String note) {
        requireNonNull(note);
        checkArgument(isValidNote(note), MESSAGE_CONSTRAINTS);
        value = note;
    }

    /**
     * Returns true if a given string is a valid note.
     */
    public static boolean isValidNote(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Memo)) {
            return false;
        }

        Memo otherMemo = (Memo) other;
        return value.equals(otherMemo.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}