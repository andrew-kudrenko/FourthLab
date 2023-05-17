package ru.bstu.akudrenko;

import ru.bstu.akudrenko.console.ConsoleColors;
import ru.bstu.akudrenko.users.UsersReader;
import ru.bstu.akudrenko.validators.*;

public class Main {
    public static void main(String[] args) {
        var usersReader = new UsersReader("src/main/resources/users.txt");

        var firstNameValidator = new FirstNameValidator();
        var lastNameValidator = new LastNameValidator();
        var dateValidator = new DateValidator();
        var phoneValidator = new PhoneValidator();

        usersReader.read().forEach(user -> {
            var validationResult = String.format(
                "First Name: %-20s | Last Name: %-40s | Phone: %-35s | Birth Date: %-25s",
                markValidness(firstNameValidator, user.FirstName()),
                markValidness(lastNameValidator, user.LastName()),
                markValidness(phoneValidator, user.Phone()),
                markValidness(dateValidator, user.BirthDate())
            );

            System.out.println(validationResult);
        });
    }

    private static String markValidness(AbstractValidator validator, String value) {
        var adornment = validator.anyMatch(value)
                ? ConsoleColors.GREEN_BRIGHT + "✔"
                : ConsoleColors.RED_BRIGHT + "❌";

        return adornment + ConsoleColors.RESET + " " + value;
    }
}