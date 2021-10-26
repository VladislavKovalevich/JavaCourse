package epam.java.chapter6.task2;

import epam.java.chapter6.task2.config.Config;
import epam.java.chapter6.task2.controller.ControllerClass;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0){
            Config.setRootPath(args[0]);
        }
        ControllerClass controllerClass = ControllerClass.getInstance();
        controllerClass.execute("start_app");
    }
}
