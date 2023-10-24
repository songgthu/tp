package seedu.address.testutil;

import seedu.address.logic.commands.EditStudentCommand.EditStudentDescriptor;
import seedu.address.model.common.Memo;
import seedu.address.model.student.CurrentLessonAttendance;
import seedu.address.model.student.Id;
import seedu.address.model.student.LessonsAttended;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditStudentDescriptorBuilder {

    private EditStudentDescriptor descriptor;

    public EditStudentDescriptorBuilder() {
        descriptor = new EditStudentDescriptor();
    }

    public EditStudentDescriptorBuilder(EditStudentDescriptor descriptor) {
        this.descriptor = new EditStudentDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing
     * {@code person}'s details
     */
    public EditStudentDescriptorBuilder(Student student) {
        descriptor = new EditStudentDescriptor();
        descriptor.setName(student.getName());
        descriptor.setId(student.getId());
        descriptor.setMemo(student.getMemo());
        descriptor.setCurrentLessonAttendance(student.getCurrentAttendance());
        descriptor.setLessonsAttended(student.getLessonsAttended());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are
     * building.
     */
    public EditStudentDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Id} of the {@code EditStudentDescriptor} that we are
     * building.
     */
    public EditStudentDescriptorBuilder withId(String id) {
        descriptor.setId(new Id(id));
        return this;
    }

    /**
     * Sets the {@code Memo} of the {@code EditStudentDescriptor} that we are
     * building.
     */
    public EditStudentDescriptorBuilder withMemo(String memo) {
        descriptor.setMemo(new Memo(memo));
        return this;
    }

    /**
     * Sets the {@code CurrentLessonAttendance} of the {@code EditStudentDescriptor} that we are
     * building.
     */
    public EditStudentDescriptorBuilder withCurrentLessonAttendance(Boolean isPresent) {
        descriptor.setCurrentLessonAttendance(new CurrentLessonAttendance(isPresent));
        return this;
    }

    /**
     * Sets the {@code LessonsAttended} of the {@code EditStudentDescriptor} that we are
     * building.
     */
    public EditStudentDescriptorBuilder withLessonsAttended(Integer lessonsAttended) {
        descriptor.setLessonsAttended(new LessonsAttended(lessonsAttended));
        return this;
    }

    public EditStudentDescriptor build() {
        return descriptor;
    }
}
