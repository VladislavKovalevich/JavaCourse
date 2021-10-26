package epam.java.chapter6.task2.entity;

public class Note {
    private int id;
    private String theme;
    private String creationDate;
    private String email;
    private String message;

    public Note(){
    }

    public int getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return  "id = " + id +
                "\ntheme = " + theme +
                "\ncreationDate = " + creationDate +
                "\nemail = " + email +
                "\nmessage = " + message + "\n";
    }
}
