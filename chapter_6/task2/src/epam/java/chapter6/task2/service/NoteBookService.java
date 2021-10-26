package epam.java.chapter6.task2.service;


import epam.java.chapter6.task2.entity.Note;
import epam.java.chapter6.task2.entity.NoteBook;
import epam.java.chapter6.task2.validator.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteBookService {

    public void showNotesList(){
        NoteBook noteBook;

        noteBook = NoteBook.getInstance();

        System.out.println("Список заметок блокнота");

        for (Note n : noteBook.getNotes()) {
            System.out.println(n);
        }
    }

    public void addNote(){
        Note note;
        Validator validator;
        NoteBook noteBook;
        ConsoleInputService consoleService;
        int newNoteId;

        note = new Note();
        validator = new Validator();
        consoleService = new ConsoleInputService();
        noteBook = NoteBook.getInstance();
        newNoteId = noteBook.getNotes().get(noteBook.getNotes().size() - 1).getId();

        note.setId(newNoteId + 1);
        note.setTheme(consoleService.getStringDataFromConsole("Введите тему заметки"));

        String email;

        email = consoleService.getStringDataFromConsole("Введите потчу заметки");

        while (!validator.isValidEmail(email)){
            System.out.println("Неверный формат почты:");
            email = consoleService.getStringDataFromConsole("Введите потчу заметки");
        }

        note.setEmail(email);
        note.setCreationDate(consoleService.getStringDataFromConsole("Введите дату заметки"));
        note.setMessage(consoleService.getStringDataFromConsole("Введите сообщение заметки"));

        noteBook.getNotes().add(note);

        System.out.println("Заметка была успешно добавлена");
    }

    public void editNote(){
        ConsoleInputService consoleService;
        NoteBook noteBook;
        int noteId;
        int maxNoteId;
        boolean isNoteExists;

        noteBook = NoteBook.getInstance();
        consoleService = new ConsoleInputService();
        isNoteExists = false;

        maxNoteId = noteBook.getNotes().get(noteBook.getNotes().size() - 1).getId();

        noteId = consoleService.getIntDataFromConsole("Введите идентификатор редактируемой заметки\n" +
                "(введите 0 для отмены операции редактирования)", 0, maxNoteId);

        while (noteId != 0){
            for (Note n: noteBook.getNotes()) {
                if (n.getId() == noteId){
                    editNoteParams(n);
                    isNoteExists = true;
                    break;
                }
            }

            if (!isNoteExists){
                System.out.println("Заметка с данным идентификатором не найдена");
            }else{
                System.out.println("Заметка изменена");
            }

            noteId = consoleService.getIntDataFromConsole("Введите идентификатор редактируемой заметки\n" +
                    "(введите 0 для отмены операции редактирования)", 0, maxNoteId);
        }
    }

    private void editNoteParams(Note note){
        int menuItem;
        ConsoleInputService consoleService;
        Validator validator;

        validator = new Validator();
        consoleService = new ConsoleInputService();

        menuItem = consoleService.getIntDataFromConsole("1 - Изменить тему заметки\n" +
                "2 - Изменить почту заметки\n" +
                "3 - Изменить дату заметки\n" +
                "4 - Изменить сообщение заметки\n" +
                "0 - Выйти из режима редактирования\n", 0, 4);

        while (menuItem != 0) {

            switch (menuItem) {
                case 1:{
                    note.setTheme(consoleService.getStringDataFromConsole("Введите новую тему заметки"));
                    break;
                }
                case 2:{
                    String email;

                    email = consoleService.getStringDataFromConsole("Введите потчу заметки");

                    while (!validator.isValidEmail(email)){
                        System.out.println("Неверный формат почты:");
                        email = consoleService.getStringDataFromConsole("Введите потчу заметки");
                    }

                    note.setEmail(email);
                    break;
                }
                case 3:{
                    note.setCreationDate(consoleService.getStringDataFromConsole("Введите новую дату создания заметки"));
                    break;
                }
                case 4:{
                    note.setMessage(consoleService.getStringDataFromConsole("Введите новое сообщение заметки"));
                    break;
                }
            }

            menuItem = consoleService.getIntDataFromConsole("1 - Изменить тему заметки\n" +
                    "2 - Изменить почту заметки\n" +
                    "3 - Изменить дату заметки\n" +
                    "4 - Изменить сообщение заметки\n" +
                    "0 - Выйти из режима редактирования\n", 0, 4);
        }
    }

    public void searchNote(){
        NoteBook noteBook;
        Pattern pattern;
        Matcher matcher;
        ConsoleInputService consoleService;
        int searchType;
        ArrayList<Note> notes;
        String keyWord;

        noteBook = NoteBook.getInstance();
        consoleService = new ConsoleInputService();
        notes = new ArrayList<>();
        keyWord = consoleService.getStringDataFromConsole("Введите ключевую фразу");
        pattern = Pattern.compile(keyWord.toLowerCase());

        searchType = consoleService.getIntDataFromConsole("1 - Поиск заметки по теме\n" +
                "2 - Поиск заметки по email\n" +
                "3 - Поиск заметки по сообщению\n" +
                "4 - Поиск заметки по теме и сообщению\n" +
                "5 - Поиск заметки по email и сообщению\n" +
                "0 - Выйти из режима поиска\n", 1, 5);

        switch (searchType){
            case 1:{
                for (Note note : noteBook.getNotes()) {
                    matcher = pattern.matcher(note.getTheme());
                    if (matcher.find()){
                        notes.add(note);
                    }
                }
                break;
            }
            case 2:{
                for (Note note : noteBook.getNotes()) {
                    matcher = pattern.matcher(note.getEmail());
                    if (matcher.find()){
                        notes.add(note);
                    }
                }
                break;
            }
            case 3:{
                for (Note note : noteBook.getNotes()) {
                    matcher = pattern.matcher(note.getMessage());
                    if (matcher.find()){
                        notes.add(note);
                    }
                }
                break;
            }
            case 4:{
                for (Note note : noteBook.getNotes()) {
                    matcher = pattern.matcher(note.getMessage() + " " + note.getTheme());
                    if (matcher.find()){
                        notes.add(note);
                    }
                }
                break;
            }
            case 5:{
                for (Note note : noteBook.getNotes()) {
                    matcher = pattern.matcher(note.getMessage() + " " + note.getEmail());
                    if (matcher.find()){
                        notes.add(note);
                    }
                }
                break;
            }
        }

        if (notes.size() > 0){
            if (notes.size() > 1) {
                notes = sortNotesByParam(notes);
            }

            for (Note note : notes) {
                System.out.println(note);
            }
        }else{
            System.out.println("Поиск по ключевой фразе ничего не нашел");
        }
    }

    private ArrayList<Note> sortNotesByParam(ArrayList<Note> notes) {
        int sortType;
        ConsoleInputService consoleService;

        consoleService = new ConsoleInputService();

        sortType = consoleService.getIntDataFromConsole("1 - Сортировка заметок по теме\n" +
                "2 - Сортировка заметок по email\n" +
                "3 - Сортировка заметок по сообщению\n" +
                "4 - Сортировка заметок по дате\n", 1, 4);

        switch (sortType){
            case 1:{
                sortNotesByTheme(notes);
                break;
            }
            case 2:{
                sortNotesByEmail(notes);
                break;
            }
            case 3:{
                sortNotesByMessage(notes);
                break;
            }
            case 4:{
                sortNotesByDate(notes);
                break;
            }
        }

        return notes;
    }

    public void sortNotesByTheme(ArrayList<Note> notes){
        notes.sort(Comparator.comparing(Note::getTheme));
    }

    public void sortNotesByEmail(ArrayList<Note> notes){
        notes.sort(Comparator.comparing(Note::getEmail));
    }

    public void sortNotesByMessage(ArrayList<Note> notes){
        notes.sort(Comparator.comparing(Note::getMessage));
    }

    public void sortNotesByDate(ArrayList<Note> notes){
        notes.sort(Comparator.comparing(Note::getCreationDate));
    }

    public void deleteNote(){
        NoteBook noteBook;
        ConsoleInputService consoleService;
        int noteId;
        int maxNoteId;
        int noteIndex = 0;

        noteBook = NoteBook.getInstance();
        consoleService = new ConsoleInputService();
        maxNoteId = noteBook.getNotes().get(noteBook.getNotes().size() - 1).getId();

        noteId = consoleService.getIntDataFromConsole("Введите идентификатор удаляемой заметки\n" +
                "(введите 0 для отмены операции удаления)", 0, maxNoteId);

        if (noteId > 0){

            for (Note n : noteBook.getNotes()) {
                if (n.getId() == noteId){
                    break;
                }
                noteIndex++;
            }

            noteBook.getNotes().remove(noteIndex);

            System.out.println("Заметка была успешно удалена");
        }else{
            System.out.println("Отмена операции удаления");
        }
    }
}
