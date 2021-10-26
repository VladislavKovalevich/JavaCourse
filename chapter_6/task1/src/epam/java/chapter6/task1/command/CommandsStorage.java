package epam.java.chapter6.task1.command;

import epam.java.chapter6.task1.command.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandsStorage {
    private Map<String, Command> commandMap = new HashMap<>();

    public CommandsStorage(){
        commandMap.put("authorization", new AuthorizedUserCommand());
        commandMap.put("show_books_list", new ShowBookListCommand());
        commandMap.put("add_book_to_list", new AddBookCommand());
        commandMap.put("edit_book", new EditBookCommand());
        commandMap.put("search_book", new SearchBookCommand());
        commandMap.put("add_user_to_list", new AddUserToListCommand());
        commandMap.put("suggest_new_book", new SuggestNewBookCommand());
    }

    public Command getCommand(String commandName){
        return commandMap.get(commandName);
    }
}
