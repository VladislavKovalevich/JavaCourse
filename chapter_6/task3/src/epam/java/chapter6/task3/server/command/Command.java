package epam.java.chapter6.task3.server.command;

import epam.java.chapter6.task3.server.ServerResponse;

public interface Command {
    ServerResponse executeCommand(String[] args);
}
