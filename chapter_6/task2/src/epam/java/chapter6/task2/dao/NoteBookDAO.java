package epam.java.chapter6.task2.dao;

import epam.java.chapter6.task2.config.Config;
import epam.java.chapter6.task2.entity.Note;
import epam.java.chapter6.task2.entity.NoteBook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NoteBookDAO {
    private final String RESOURCE_NOTEBOOK = "notebook.json";

    public NoteBookDAO(){

    }

    public ArrayList<Note> loadDataFromFile(){
        ArrayList<Note> notes;
        JSONParser jsonParser;
        JSONArray jsonArray;
        JSONObject rootJsonObject;

        jsonParser = new JSONParser();
        notes = new ArrayList<>();

        try(FileReader fileReader = new FileReader(Config.getRootPath() + RESOURCE_NOTEBOOK)) {

            rootJsonObject = (JSONObject) jsonParser.parse(fileReader);
            jsonArray = (JSONArray) rootJsonObject.get("notebook");

            JSONObject jsonObject;
            Note note;

            for (Object object : jsonArray) {
                note = new Note();
                jsonObject = (JSONObject) object;

                note.setId(Integer.parseInt((String)jsonObject.get("id")));
                note.setTheme((String) jsonObject.get("theme"));
                note.setEmail((String) jsonObject.get("email"));
                note.setCreationDate((String) jsonObject.get("date"));
                note.setMessage((String) jsonObject.get("message"));

                notes.add(note);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


        return notes;
    }

    public void saveDataToFile(){
        JSONObject rootJsonObject;
        JSONArray jsonArray;
        NoteBook noteBook;

        rootJsonObject = new JSONObject();
        jsonArray = new JSONArray();
        noteBook = NoteBook.getInstance();

        try(FileWriter fileWriter = new FileWriter(Config.getRootPath() + RESOURCE_NOTEBOOK)){

            JSONObject jsonObject;

            for (Note note : noteBook.getNotes()) {
                jsonObject = new JSONObject();

                jsonObject.put("id", String.valueOf(note.getId()));
                jsonObject.put("theme", note.getTheme());
                jsonObject.put("email", note.getEmail());
                jsonObject.put("date", note.getCreationDate());
                jsonObject.put("message", note.getMessage());

                jsonArray.add(jsonObject);
            }

            rootJsonObject.put("notebook", jsonArray);

            fileWriter.write(rootJsonObject.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
