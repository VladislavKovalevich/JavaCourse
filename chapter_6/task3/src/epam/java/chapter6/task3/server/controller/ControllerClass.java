package epam.java.chapter6.task3.server.controller;


import epam.java.chapter6.task3.server.ServerResponse;
import epam.java.chapter6.task3.server.command.CommandClass;

public class ControllerClass implements Controller{
    private static ControllerClass instance;

    private final CommandClass commandClass;

    private ControllerClass(){
        commandClass = new CommandClass();
    }

    public static ControllerClass getInstance(){
        if (instance == null){
            instance = new ControllerClass();
        }
        return instance;
    }


    @Override
    public ServerResponse execute(String command, String[] args) {
        return commandClass.getCommand(command).executeCommand(args);
    }
}
