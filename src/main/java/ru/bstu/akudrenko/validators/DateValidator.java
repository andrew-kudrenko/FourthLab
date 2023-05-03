package ru.bstu.akudrenko.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DateValidator extends AbstractValidator {
    @Override
    protected List<Pattern> createInitialPatterns() {
        var patternSources = new ArrayList<>(
            List.of(
                "\\d{2}%s\\d{2}%s(\\d{4}|\\d{2})",
                "(\\d{4}|\\d{2})%s\\d{2}%s\\d{2}"
            )
        );
        var delimiters = new ArrayList<>(List.of(":", "\\.", "-"));

        return patternSources
            .stream()
            .flatMap(pattern -> delimiters
                .stream()
                .map(d -> Pattern.compile(String.format(pattern, d, d)))
            )
            .toList();
    }
}
