package epam.java.chapter6.task2.controller;


import epam.java.chapter6.task2.command.CommandClass;

public class ControllerClass implements Controller {
    private static ControllerClass instance;
    private final CommandClass commandClass = new CommandClass();

    public static ControllerClass getInstance(){
        if (instance == null){
            instance = new ControllerClass();
        }

        return instance;
    }

    @Override
    public void execute(String command) {
        commandClass.getCommand(command).executeCommand();
    }
}
