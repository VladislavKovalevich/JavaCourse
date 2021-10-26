package epam.java.chapter6.task1.command.commands;

import epam.java.chapter6.task1.command.Command;
import epam.java.chapter6.task1.logic.LibraryService;
import epam.java.chapter6.task1.logic.Service;

public class SearchBookCommand implements Command {
    private final LibraryService libraryService = Service.getInstance().getLibraryService();

    @Override
    public void executeCommand() {
        libraryService.searchBook();
    }
}
