package epam.java.chapter4.task1.entity;

import java.util.Arrays;

public class Word {
    private String word;

    public Word(String word){
        this.word = word;
    }

    public Word(char[] word){
        this.word = Arrays.toString(word);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}
