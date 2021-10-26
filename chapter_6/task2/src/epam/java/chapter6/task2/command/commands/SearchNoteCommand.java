package epam.java.chapter6.task2.command.commands;


import epam.java.chapter6.task2.command.Command;
import epam.java.chapter6.task2.service.NoteBookService;
import epam.java.chapter6.task2.service.Service;

public class SearchNoteCommand implements Command {
    private final NoteBookService noteBookLogic = Service.getInstance().getNoteBookService();

    @Override
    public void executeCommand() {
        noteBookLogic.searchNote();
    }
}
