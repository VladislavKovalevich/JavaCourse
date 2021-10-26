package epam.java.chapter6.task1.command.commands;

import epam.java.chapter6.task1.command.Command;
import epam.java.chapter6.task1.logic.Service;
import epam.java.chapter6.task1.logic.UserService;

public class AuthorizedUserCommand implements Command {
    private final UserService userService = Service.getInstance().getUserService();

    @Override
    public void executeCommand() {
        userService.authorization();
    }
}
