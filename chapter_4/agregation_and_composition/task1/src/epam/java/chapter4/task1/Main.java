package epam.java.chapter4.task1;


import epam.java.chapter4.task1.entity.Sentence;
import epam.java.chapter4.task1.entity.Text;
import epam.java.chapter4.task1.entity.Word;
import epam.java.chapter4.task1.action.TextAction;

/**
 * Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
 * консоль текст, заголовок текста.
 */
public class Main {
    public static void main(String[] args) {
        Word[] title = new Word[]{new Word("Text"), new Word("Title")};
        Word author = new Word("Joseph I.A.");
        Sentence[] sentences = {
                new Sentence(new Word[]{new Word("Hi"), new Word("Mark")}, '!'),
                new Sentence(new Word[]{new Word("Hello,"), new Word("how"), new Word("are"), new Word("you")}, '?'),
                new Sentence(new Word[]{new Word("I"), new Word("am"), new Word("fine,"), new Word("and"), new Word("you")}, '?'),
                new Sentence(new Word[]{new Word("I"), new Word("am"), new Word("too")}, '.'),
        };

        Text text = new Text(title,sentences,author);
        TextAction textAction = new TextAction();

        System.out.println(textAction.getTextTitle(text));

        System.out.println(textAction.printText(text) + "\n");

        Sentence addSentence = new Sentence(new Word[]{new Word("I"), new Word("am"), new Word("too")}, '?');

        text = textAction.addSentenceToText(addSentence, text);

        System.out.println(textAction.printText(text));
    }
}
