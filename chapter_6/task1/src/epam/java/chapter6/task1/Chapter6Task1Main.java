package epam.java.chapter6.task1;

import epam.java.chapter6.task1.config.Config;
import epam.java.chapter6.task1.controller.ControllerClass;

public class Chapter6Task1Main {
    public static void main(String[] args) {
        if (args.length > 0){
            Config.setRootPath(args[0]);
        }

        ControllerClass controller = ControllerClass.getInstance();
        controller.execute("authorization");
    }
}