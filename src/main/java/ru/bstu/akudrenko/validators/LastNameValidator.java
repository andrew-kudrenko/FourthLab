package ru.bstu.akudrenko.validators;

import java.util.List;
import java.util.regex.Pattern;

public class LastNameValidator extends AbstractValidator {
    @Override
    protected List<Pattern> createInitialPatterns() {
        return List.of(
            Pattern.compile("[А-яЁё]+(-[А-яЁё]+)*"),
            Pattern.compile("\\w+(-\\w+)*")
        );
    }
}
