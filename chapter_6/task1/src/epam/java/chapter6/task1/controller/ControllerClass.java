package epam.java.chapter6.task1.controller;

import epam.java.chapter6.task1.command.CommandsStorage;

public class ControllerClass implements Controller{
    private static ControllerClass instance;
    private final CommandsStorage commandsStorage;

    private ControllerClass(){
        commandsStorage = new CommandsStorage();
    }

    public static ControllerClass getInstance(){
        if (instance == null){
            instance = new ControllerClass();
        }

        return instance;
    }

    @Override
    public void execute(String command) {
        commandsStorage.getCommand(command).executeCommand();
    }
}
