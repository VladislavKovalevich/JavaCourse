package epam.java.chapter6.task1.command.commands;

import epam.java.chapter6.task1.command.Command;
import epam.java.chapter6.task1.logic.Service;
import epam.java.chapter6.task1.logic.UserService;

public class AddUserToListCommand implements Command {
    private final UserService userService = Service.getInstance().getUserService();

    @Override
    public void executeCommand() {
        userService.addUser();
    }
}
