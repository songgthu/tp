package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddClassCommand;
import seedu.address.model.common.Memo;
import seedu.address.model.module.Class;
import seedu.address.model.module.ClassName;
import seedu.address.model.module.Schedule;
import seedu.address.model.student.UniqueStudentList;

public class AddClassCommandParserTest {
    private AddClassCommandParser parser = new AddClassCommandParser();

    private final String invalidClassName = "cs 2103t";

    private final String validClassName = "cs2103t";

    @Test
    public void parse_allFieldsPresent_success() {
        ClassName className = new ClassName("cs2103t");
        Class expectedClass = new Class(className, new UniqueStudentList(), new Memo(" "), new Schedule());
        AddClassCommand expectedCommand = new AddClassCommand(expectedClass);
        assertParseSuccess(parser, " /c " + validClassName, expectedCommand);
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, " add /c " + invalidClassName,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddClassCommand.MESSAGE_USAGE));
    }
}
