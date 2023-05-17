package ru.bstu.akudrenko.validators;

import java.util.List;
import java.util.regex.Pattern;

public class FirstNameValidator extends AbstractValidator {
    @Override
    protected List<Pattern> createInitialPatterns() {
        return List.of(
                Pattern.compile("[А-яЁё]+"),
                Pattern.compile("[A-z]+")
        );
    }
}
