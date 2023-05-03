package ru.bstu.akudrenko.validators;

import java.util.List;
import java.util.regex.Pattern;

public abstract class AbstractValidator {
    protected List<Pattern> patterns = createInitialPatterns();

    public boolean anyMatch(String text) {
        return patterns.stream().anyMatch(p -> p.matcher(text).matches());
    }

    protected List<Pattern> createInitialPatterns() {
        return List.of();
    }
}
