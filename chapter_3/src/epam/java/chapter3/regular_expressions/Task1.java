package epam.java.chapter3.regular_expressions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
 * операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
 * алфавиту.
 */
public class Task1 {
    private static final Pattern paragraphPattern = Pattern.compile("\t.+\n*[^\t]+");
    private static final Pattern sentencePattern = Pattern.compile("(?Us).*?(?:[?!.]\\s+)");
    private static final Pattern wordPattern = Pattern.compile("\\w+[,]?");

    public static void main(String[] args) {
        String inputSting;
        Scanner scanner;
        int code;

        inputSting = "\tLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt! Venenatis a condimentum vitae sapien pellentesque habitant morbi. Tristique risus nec feugiat in fermentum posuere urna nec. Tellus in hac habitasse platea dictumst vestibulum. Rutrum tellus pellentesque eu tincidunt tortor. Imperdiet sed euismod nisi porta. Varius sit amet mattis vulputate enim nulla aliquet. Quam adipiscing vitae proin sagittis nisl rhoncus mattis. Euismod in pellentesque massa placerat duis ultricies lacus sed. Amet cursus sit amet dictum? Erat velit scelerisque in dictum non consectetur a erat nam!" +
                "\n\tNisl pretium fusce id velit ut. " +
                "Vitae et leo duis ut diam quam nulla. Duis at consectetur lorem donec massa sapien faucibus. " +
                "Eros donec ac odio tempor orci. Aliquam vestibulum morbi blandit cursus risus. Nisl nunc mi ipsum faucibus vitae aliquet nec. Faucibus purus in massa tempor nec feugiat nisl. Molestie nunc non blandit massa enim nec dui nunc. Pulvinar mattis nunc sed blandit libero volutpat sed. Duis tristique sollicitudin nibh sit. Sit amet nulla facilisi morbi tempus iaculis. Pellentesque nec nam aliquam sem et tortor. In hac habitasse platea dictumst vestibulum rhoncus. At auctor urna nunc id cursus metus aliquam eleifend mi. Enim nec dui nunc mattis enim? Pellentesque nec nam aliquam sem et tortor consequat id. Aliquet porttitor lacus luctus accumsan tortor posuere ac ut. Risus at ultrices mi tempus imperdiet nulla malesuada." +
                "\n\tAliquam ultrices sagittis orci a scelerisque purus semper eget duis. Vel orci porta non pulvinar neque laoreet suspendisse interdum. Vel risus commodo viverra maecenas accumsan lacus vel. Pretium vulputate sapien nec sagittis aliquam. Convallis tellus id interdum velit. Potenti nullam ac tortor vitae purus faucibus. Odio eu feugiat pretium nibh ipsum consequat nisl. Vulputate mi sit amet mauris commodo. Justo nec ultrices dui sapien eget. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet. Risus nec feugiat in fermentum posuere urna nec tincidunt! Parturient montes nascetur ridiculus mus mauris. Fames ac turpis egestas sed tempus urna et pharetra. Est velit egestas dui id ornare arcu odio ut. Arcu odio ut sem nulla. Nisi est sit amet facilisis magna. In ante metus dictum at tempor. Habitant morbi tristique senectus et netus. Venenatis urna cursus eget nunc scelerisque viverra mauris.\n\t";

        scanner = new Scanner(System.in);
        code = 1;

        getDocumentation();

        while (code != 0 ){
            System.out.println("Введите код команды:");
            try{
                code = scanner.nextInt();

                switch (code){
                    case 0: {
                        break;
                    }
                    case 1:{
                        getDocumentation();
                        break;
                    }
                    case 2:{
                        System.out.println();
                        System.out.println(inputSting);
                        System.out.println();
                        break;
                    }
                    case 3:{
                        sortParagraphs(inputSting);
                        break;
                    }
                    case 4:{
                        sortWordsByLengthInSentence(inputSting);
                        break;
                    }
                    case 5:{
                        sortWordsInSentenceByInputSymbol(inputSting, 'i');
                        break;
                    }
                }

            }catch (InputMismatchException ex){
                System.out.println("Неверный код");
            }
        }

        System.out.println("Завершение работы приложения");
    }

    private static void getDocumentation(){
        System.out.println("\n" +
                "Список кодов команд приложения:\n" +
                "0 - Выход\n" +
                "1 - Отображение списка кодов\n" +
                "2 - Вывод текста\n" +
                "3 - Сортировка абзацев по количеству предложений\n" +
                "4 - Сортировка слов в предложениях по их длинне\n" +
                "5 - Сортировка лексем в предложении по убыванию количества вхождений данного символа\n");
    }

    private static void sortParagraphs(String string){
        Matcher paragraphMatcher;
        Matcher sentenceMatcher;

        List<String> currentParagraph = new ArrayList<>();
        List<Integer> countSentence = new ArrayList<>();

        int sentenceCount;

        paragraphMatcher = paragraphPattern.matcher(string);

        while (paragraphMatcher.find()){
            currentParagraph.add(paragraphMatcher.group());

            sentenceMatcher = sentencePattern.matcher(paragraphMatcher.group());
            sentenceCount = 0;

            while (sentenceMatcher.find()){
                sentenceCount++;
            }

            countSentence.add(sentenceCount);
        }

        System.out.println(sortParagraphsBySentenceCount(countSentence, currentParagraph));
    }

    private static String sortParagraphsBySentenceCount(List<Integer> countSentence, List<String> currentParagraph) {
        int i;
        int max;
        int maxIndex;
        StringBuilder finalString;

        i = countSentence.size();
        finalString = new StringBuilder();

        while (i > 0){
            maxIndex = 0;
            max = countSentence.get(0);
            for (int j = 1; j < i; j++) {
                if(max < countSentence.get(j)){
                    max = countSentence.get(j);
                    maxIndex = j;
                }
            }

            finalString.append(currentParagraph.get(maxIndex));

            countSentence.remove(maxIndex);
            currentParagraph.remove(maxIndex);

            i--;
        }

        return finalString.toString();
    }

    private static void sortWordsByLengthInSentence(String string){
        Matcher paragraphMatcher;
        Matcher sentenceMatcher;
        Matcher wordMatcher;

        StringBuilder stringBuilder = new StringBuilder("\t");

        paragraphMatcher = paragraphPattern.matcher(string);

        while (paragraphMatcher.find()){
            sentenceMatcher = sentencePattern.matcher(paragraphMatcher.group());

            while (sentenceMatcher.find()){
                wordMatcher = wordPattern.matcher(sentenceMatcher.group());

                int wordsCount = 0;
                String[] sentencesWords = new String[30];

                while (wordMatcher.find()){
                    sentencesWords[wordsCount] = wordMatcher.group();
                    wordsCount++;
                }

                char lastSentenceChar = string.charAt(sentenceMatcher.end()+paragraphMatcher.start() - 2);

                String[] sortedSentence;
                sortedSentence = sortWordsByLength(sentencesWords, wordsCount);

                String newSentence;
                newSentence = buildSentenceFromWordsArray(wordsCount, sortedSentence, lastSentenceChar);
                stringBuilder.append(newSentence);
            }

            stringBuilder.append("\n\t");
        }

        System.out.println(stringBuilder);
    }

    private static void sortWordsInSentenceByInputSymbol(String string, char symbol){
        Matcher paragraphMatcher;
        Matcher sentenceMatcher;
        Matcher wordMatcher;

        StringBuilder stringBuilder = new StringBuilder("\t");

        paragraphMatcher = paragraphPattern.matcher(string);

        while (paragraphMatcher.find()){
            sentenceMatcher = sentencePattern.matcher(paragraphMatcher.group());

            while (sentenceMatcher.find()){
                wordMatcher = wordPattern.matcher(sentenceMatcher.group());

                int wordsCount = 0;
                String[] sentencesWords = new String[30];

                while (wordMatcher.find()){
                    sentencesWords[wordsCount] = wordMatcher.group();
                    wordsCount++;
                }

                char lastSentenceChar = string.charAt(sentenceMatcher.end()+paragraphMatcher.start() - 2);

                String[] sortedSentence;
                sortedSentence = sortWordsBySymbol(wordsCount, sentencesWords, symbol);

                String newSentence;
                newSentence = buildSentenceFromWordsArray(wordsCount, sortedSentence, lastSentenceChar);
                stringBuilder.append(newSentence);
            }

            stringBuilder.append("\n\t");
        }

        System.out.println(stringBuilder);
    }

    private static String[] sortWordsBySymbol(int wordsCount, String[] sentence, char symbol){
        for (int i = 0; i < wordsCount - 1; i++) {

            for (int j = wordsCount - 1; j > i; j--) {

                if (compareWords(sentence[j-1], sentence[j], symbol) == 1){

                    String temp;
                    temp = sentence[j - 1];
                    sentence[j - 1] = sentence[j];
                    sentence[j] = temp;
                }

            }

        }

        return sentence;
    }

    private static String[] sortWordsByLength(String[] sentence, int wordsCount){

        for (int i = 0; i < wordsCount - 1; i++) {

            for (int j = wordsCount - 1; j > i; j--) {

                int currWordLength = sentence[j - 1].length();
                int nextWordLength = sentence[j].length();

                if (sentence[j - 1].indexOf(',') > 0){
                    currWordLength--;
                }

                if (sentence[j].indexOf(',') > 0){
                    nextWordLength--;
                }
                if (currWordLength > nextWordLength){

                    String temp;
                    temp = sentence[j - 1];
                    sentence[j - 1] = sentence[j];
                    sentence[j] = temp;
                }

            }

        }

        return sentence;
    }

    private static String buildSentenceFromWordsArray(int wordsCount, String[] sentencesWords, char lastSentenceChar){
        StringBuilder result;

        result = new StringBuilder();

        for (int i = 0; i < wordsCount; i++) {
            result.append(sentencesWords[i]);

            if (i == wordsCount - 1){
                result.append(lastSentenceChar).append(" ");
            }else {
                result.append(" ");
            }
        }

        return result.toString();
    }

    private static int compareWords(String currWord, String nextWord, char symbol) {
        Pattern p;
        Matcher m;
        int counter;
        int result;

        p = Pattern.compile(String.valueOf(symbol));
        m = p.matcher(currWord);

        result = 0;
        counter = 0;

        while (m.find()){
            counter++;
        }

        m = p.matcher(nextWord);

        while (m.find()){
            counter--;
        }

        if (counter < 0){
            result = 1;
        }else if(counter == 0){
            if (currWord.toUpperCase().compareTo(nextWord.toUpperCase()) >= 0){
                result = 1;
            }
        }

        return result;
    }
}
