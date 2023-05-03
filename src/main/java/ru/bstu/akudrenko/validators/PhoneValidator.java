package ru.bstu.akudrenko.validators;

import java.util.List;
import java.util.regex.Pattern;

public class PhoneValidator extends AbstractValidator {
    @Override
    protected List<Pattern> createInitialPatterns() {
        return List.of(
            Pattern.compile("\\+?\\d{1,3}((-?\\d{3}-?)|(\\(\\d{3}\\)))\\d{3}-?\\d{2}-?\\d{2}")
        );
    }
}
