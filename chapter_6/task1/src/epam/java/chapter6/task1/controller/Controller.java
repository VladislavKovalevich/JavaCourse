package epam.java.chapter6.task1.controller;

import epam.java.chapter6.task1.command.CommandEnum;

public interface Controller {
    void execute(CommandEnum operation);
}
