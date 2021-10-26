package epam.java.chapter4.task1.entity;

public class Text {
    private Word[] title;
    private Sentence[] sentences;
    private Word author;

    public Text(Word[] title, Sentence[] sentences, Word author){
        this.title = title;
        this.sentences = sentences;
        this.author = author;
    }


    public Word[] getTitle() {
        return title;
    }

    public void setTitle(Word[] title) {
        this.title = title;
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    public void setSentences(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public Word getAuthor() {
        return author;
    }

    public void setAuthor(Word author) {
        this.author = author;
    }
}
