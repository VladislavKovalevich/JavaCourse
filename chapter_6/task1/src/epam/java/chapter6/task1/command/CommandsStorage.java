package epam.java.chapter6.task1.command;

import epam.java.chapter6.task1.command.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandsStorage {
    private Map<CommandEnum, Command> commandMap = new HashMap<>();

    public CommandsStorage(){
        commandMap.put(CommandEnum.AUTH, new AuthorizedUserCommand());
        commandMap.put(CommandEnum.SHOW_BOOKS, new ShowBookListCommand());
        commandMap.put(CommandEnum.ADD_BOOK, new AddBookCommand());
        commandMap.put(CommandEnum.EDIT_BOOK, new EditBookCommand());
        commandMap.put(CommandEnum.SEARCH_BOOK, new SearchBookCommand());
        commandMap.put(CommandEnum.ADD_USER, new AddUserToListCommand());
        commandMap.put(CommandEnum.SUGGEST_NEW_BOOK, new SuggestNewBookCommand());
    }

    public Command getCommand(CommandEnum commandName){
        return commandMap.get(commandName);
    }
}
