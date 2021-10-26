package epam.java.chapter6.task2.command;


import epam.java.chapter6.task2.command.commands.*;

import java.util.HashMap;

public class CommandClass {
    private HashMap<String, Command> commandHashMap = new HashMap<>();

    public CommandClass() {
        commandHashMap.put("start_app", new StartApplicationCommand());
        commandHashMap.put("add_note", new AddNoteCommand());
        commandHashMap.put("edit_note", new EditNoteCommand());
        commandHashMap.put("delete_note", new DeleteNoteCommand());
        commandHashMap.put("search_note", new SearchNoteCommand());
        commandHashMap.put("show_notes", new ShowNotesList());
    }

    public Command getCommand(String commandKey){
        return commandHashMap.get(commandKey);
    }
}
