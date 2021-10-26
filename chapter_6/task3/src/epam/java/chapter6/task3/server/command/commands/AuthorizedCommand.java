package epam.java.chapter6.task3.server.command.commands;


import epam.java.chapter6.task3.server.ServerResponse;
import epam.java.chapter6.task3.server.command.Command;
import epam.java.chapter6.task3.server.service.Service;
import epam.java.chapter6.task3.server.service.UserService;

public class AuthorizedCommand implements Command {
    private final UserService userService = Service.getInstance().getUserService();

    @Override
    public ServerResponse executeCommand(String[] args) {
        return userService.authorizedUser(args);
    }
}
