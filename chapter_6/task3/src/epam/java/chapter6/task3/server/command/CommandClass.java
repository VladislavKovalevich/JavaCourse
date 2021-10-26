package epam.java.chapter6.task3.server.command;


import epam.java.chapter6.task3.server.command.commands.*;

import java.util.HashMap;

public class CommandClass {
    private HashMap<String, Command> commandHashMap = new HashMap<>();

    public CommandClass(){
        commandHashMap.put("add_file", new AddFileCommand());
        commandHashMap.put("show_files", new ShowFileCommand());
        commandHashMap.put("edit_file", new EditFileCommand());
        commandHashMap.put("search_file", new SearchFileCommand());
        commandHashMap.put("authorized_user", new AuthorizedCommand());
    }

    public Command getCommand(String command){
        return commandHashMap.get(command);
    }

}
