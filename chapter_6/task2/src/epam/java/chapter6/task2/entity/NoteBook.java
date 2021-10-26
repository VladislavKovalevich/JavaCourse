package epam.java.chapter6.task2.entity;


import epam.java.chapter6.task2.dao.NoteBookDAO;

import java.util.ArrayList;

public class NoteBook {
    private ArrayList<Note> notes;

    private static NoteBook instance = new NoteBook();

    private NoteBook(){
        NoteBookDAO noteBookDAO = new NoteBookDAO();
        this.notes = noteBookDAO.loadDataFromFile();
    }

    public static NoteBook getInstance(){
        return instance;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }
}
