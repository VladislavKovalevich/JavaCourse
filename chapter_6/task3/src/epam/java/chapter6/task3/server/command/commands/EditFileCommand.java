package epam.java.chapter6.task3.server.command.commands;


import epam.java.chapter6.task3.server.ServerResponse;
import epam.java.chapter6.task3.server.command.Command;
import epam.java.chapter6.task3.server.service.Service;
import epam.java.chapter6.task3.server.service.StudentFilesService;

public class EditFileCommand implements Command {
    private final StudentFilesService studentFilesService = Service.getInstance().getStudentFilesService();


    @Override
    public ServerResponse executeCommand(String[] args) {
        return studentFilesService.editFile(args);
    }
}
