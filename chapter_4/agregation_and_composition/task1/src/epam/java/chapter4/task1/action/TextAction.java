package epam.java.chapter4.task1.action;


import epam.java.chapter4.task1.entity.Sentence;
import epam.java.chapter4.task1.entity.Text;
import epam.java.chapter4.task1.entity.Word;

public class TextAction {
    public TextAction(){

    }

    public StringBuilder printText(Text text){
        StringBuilder tempText;

        tempText = getTextTitle(text);

        for (Sentence s : text.getSentences()) {

            StringBuilder tempSentence = new StringBuilder();

            for (Word w : s.getWords()) {
                tempSentence.append(w.getWord()).append(" ");
            }

            tempSentence.setCharAt(0, Character.toUpperCase(tempSentence.charAt(0)));
            tempSentence.setCharAt(tempSentence.length() - 1, s.getPunctuationMark());
            tempSentence.append(" ");

            tempText.append(tempSentence.toString());
        }

        tempText.append("\n\n");
        tempText.append(text.getAuthor().getWord());

        return tempText;
    }

    public StringBuilder getTextTitle(Text text){
        StringBuilder textTitle = new StringBuilder("\t\t\t");

        for (Word w : text.getTitle()) {
            textTitle.append(w.getWord()).append(" ");
        }

        textTitle.append("\n\n");

        return textTitle;
    }

    public Text addSentenceToText(Sentence sentence, Text text){
        Sentence[] tempSentences = new Sentence[text.getSentences().length + 1];

        for (int i = 0; i < text.getSentences().length; i++) {
            tempSentences[i] = text.getSentences()[i];
        }

        tempSentences[tempSentences.length - 1] = sentence;

        text.setSentences(tempSentences);


        return text;
    }
}
