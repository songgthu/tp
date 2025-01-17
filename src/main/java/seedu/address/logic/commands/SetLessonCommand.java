package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.commands.RemoveClassCommand.MESSAGE_MISSING_CLASS_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLASS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LESSONQUANTITY;

import java.util.List;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.Class;
import seedu.address.model.module.ClassName;
import seedu.address.model.module.exceptions.ClassNotFoundException;
import seedu.address.model.student.Student;

/**
 * Sets the number of lessons of a Class.
 */
public class SetLessonCommand extends Command {
    public static final String COMMAND_WORD = "setlesson /c";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sets the total number of lessons in the Class.\n"
            + "Parameters: "
            + PREFIX_CLASS + " CLASS_NAME"
            + "\n"
            + PREFIX_LESSONQUANTITY + " NUMBER_OF_LESSON"
            + "\n"
            + "Example: "
            + COMMAND_WORD + " cs2103" + " /l 5";
    public static final String MESSAGE_SET_LESSON_SUCCESS = "Successfully set the number of lessons in %s to %d!";
    private ClassName className;
    private int numLessons;

    /**
     * Command to forcefully set the total number of lessons of a Class.
     * @param className Classname to represent the Class.
     */
    public SetLessonCommand(ClassName className, int numLessons) {
        requireAllNonNull(className);
        assert numLessons >= 0 : "number of lessons should be at least 0";
        this.className = className;
        this.numLessons = numLessons;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {

        requireNonNull(model);
        Class c = null;
        try {
            c = model.getClass(className);
            model.setClassLesson(c, numLessons);
            // Verify Student's total lessons attended do not exceed the total lessons of Clas
            List<Student> studentList = c.getStudentList();
            for (Student studentToVerify : studentList) {
                if (!model.isValidAttendanceForStudent(studentToVerify, c)) {
                    if (numLessons == 0 && studentToVerify.isPresentForLesson()) {
                        studentToVerify.markStudentAbsent();
                    }
                    Student editedStudent = studentToVerify.duplicateStudent();
                    model.setStudentLesson(studentToVerify, c, editedStudent, numLessons);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new CommandException(String.format(MESSAGE_MISSING_CLASS_NAME, className));
        }

        return new CommandResult(String.format(MESSAGE_SET_LESSON_SUCCESS,
                Messages.formatClass(c), numLessons));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SetLessonCommand)) {
            return false;
        }

        SetLessonCommand otherSetLessonCommand = (SetLessonCommand) other;
        return this.className.equals(otherSetLessonCommand.className)
                && this.numLessons == otherSetLessonCommand.numLessons;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("className", this.className.toString())
                .add("numLessons", String.valueOf(this.numLessons))
                .toString();
    }
}
