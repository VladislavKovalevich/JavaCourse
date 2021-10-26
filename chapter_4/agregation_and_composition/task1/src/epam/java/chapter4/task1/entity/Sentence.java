package epam.java.chapter4.task1.entity;

import java.util.Arrays;

public class Sentence {
    private Word[] words;
    private char punctuationMark;

    public Sentence(Word[] words, char punctuationMark){
        this.punctuationMark = punctuationMark;
        this.words = words;
    }

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    public char getPunctuationMark() {
        return punctuationMark;
    }

    public void setPunctuationMark(char punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "words=" + Arrays.toString(words) +
                ", punctuationMark=" + punctuationMark +
                '}';
    }
}
