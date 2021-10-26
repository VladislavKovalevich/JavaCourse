package epam.java.chapter6.task2.command.commands;


import epam.java.chapter6.task2.command.Command;
import epam.java.chapter6.task2.service.Service;
import epam.java.chapter6.task2.service.UserService;

public class StartApplicationCommand implements Command {
    private final UserService userLogic = Service.getInstance().getUserService();

    @Override
    public void executeCommand() {
        userLogic.getUserMenu();
    }
}
