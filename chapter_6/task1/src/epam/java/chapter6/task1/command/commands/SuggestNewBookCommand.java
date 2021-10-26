package epam.java.chapter6.task1.command.commands;

import epam.java.chapter6.task1.command.Command;
import epam.java.chapter6.task1.entity.Library;
import epam.java.chapter6.task1.entity.user.User;
import epam.java.chapter6.task1.logic.Service;
import epam.java.chapter6.task1.logic.UserService;

public class SuggestNewBookCommand implements Command {
    private final UserService userService = Service.getInstance().getUserService();
    private final User user = Library.getInstance().getAuthorizedUser();

    @Override
    public void executeCommand() {
        userService.suggestNewBook(user);
    }
}
