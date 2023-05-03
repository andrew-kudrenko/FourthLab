package ru.bstu.akudrenko.users;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class UsersReader {
    private final File inputFile;

    public UsersReader(String inputFilePath) {
        inputFile = new File(inputFilePath);
    }

    public List<User> read() {
        try (var linesStream = Files.lines(inputFile.toPath())) {
            return linesStream
                    .map(line -> {
                        var parts = line.split(" ");
                        return new User(parts[0], parts[1], parts[2], parts[3]);
                    })
                    .toList();
        } catch (Exception e) {
            return List.of();
        }
    }
}
