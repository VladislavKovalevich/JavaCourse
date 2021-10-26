package epam.java.chapter6.task3.server.controller;

import epam.java.chapter6.task3.server.ServerResponse;

public interface Controller {
    ServerResponse execute(String command, String[] args);
}
