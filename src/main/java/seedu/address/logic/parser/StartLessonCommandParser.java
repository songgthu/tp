package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLASS;

import java.util.stream.Stream;

import seedu.address.logic.commands.StartLessonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.module.ClassName;

/**
 * Parses input arguments and create a new StartLessonCommand.
 */
public class StartLessonCommandParser implements Parser<StartLessonCommand> {
    /**
     * Parses the input arguments and create a StartLessonCommand based on input arguments.
     * @param args Inputs by user to determine Class that StartLessonCommand should work on.
     * @return StartLessonCommand with user's chosen Class.
     */
    public StartLessonCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_CLASS);

        if (!arePrefixesPresent(argMultimap, PREFIX_CLASS)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    StartLessonCommand.MESSAGE_USAGE));
        }
        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_CLASS);
        ClassName className = ParserUtil.parseClassName(argMultimap.getValue(PREFIX_CLASS).get());
        return new StartLessonCommand(className);
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
