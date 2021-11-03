package epam.java.chapter3.regular_expressions;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Дана строка, содержащая следующий текст (xml-документ):
 * <notes>
 *     <note id = "1">
 *         <to>Вася</to>
 *         <from>Света</from>
 *         <heading>Напоминание</heading>
 *         <body>Позвони мне завтра!</body>
 *     </note>
 *         <note id = "2">
 *         <to>Петя</to>
 *         <from>Маша</from>
 *         <heading>Важное напоминание</heading>
 *     <body/>
 *     </note>
 * </notes>
 * Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
 * тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
 * нельзя.
 */

public class Task2 {
    private static final String OPEN_TAG_PATTERN = "<\\w.+?>";
    private static final String CLOSE_TAG_PATTERN = "</\\w.+?>";
    private static final String TAG_INFO_PATTERN = ">.+?<";
    private static final String EMPTY_TAG_PATTERN = "<\\w.+?>";

    public static void main(String[] args) {
        String xmlString;

        xmlString = "<notes>\n" +
                "    <note id = \"1\">\n" +
                "        <to>Вася</to>\n" +
                "        <from>Света</from>\n" +
                "        <heading>Напоминание</heading>\n" +
                "        <body>Позвони мне завтра!</body>\n" +
                "    </note>\n" +
                "        <note id = \"2\">\n" +
                "        <to>Петя</to>\n" +
                "        <from>Маша</from>\n" +
                "        <heading>Важное напоминание</heading>\n" +
                "    <body/>\n" +
                "    </note>\n" +
                "</notes>";

        StringBuilder parsingString;

        parsingString = customXMLParser(xmlString);

        System.out.println(parsingString);
    }

    private static StringBuilder customXMLParser(String xmlString) {
        Pattern pOpenTag = Pattern.compile(OPEN_TAG_PATTERN);
        Pattern pCloseTag = Pattern.compile(CLOSE_TAG_PATTERN);
        Pattern pInfoTag = Pattern.compile(TAG_INFO_PATTERN);
        Pattern pEmptyTag = Pattern.compile(EMPTY_TAG_PATTERN);

        String[] array;
        array = xmlString.split("\n");

        StringBuilder stringBuilder = new StringBuilder();

        for (String string : array) {
            Matcher mOpenTag = pOpenTag.matcher(string);
            Matcher mCloseTag = pCloseTag.matcher(string);
            Matcher mInfoTag = pInfoTag.matcher(string);
            Matcher mEmptyTag = pEmptyTag.matcher(string);

            if (mOpenTag.find()){
                stringBuilder.append(mOpenTag.group());
                stringBuilder.append("---------OPEN\n");
            }

            if (mCloseTag.find()){
                stringBuilder.append(mCloseTag.group());
                stringBuilder.append("---------CLOSE\n");
            }

            if (mInfoTag.find()){
                stringBuilder.append(mInfoTag.group(), 1, (mInfoTag.group().length() - 1));
                stringBuilder.append("---------INFO\n");
            }

            if (mEmptyTag.find()){
                stringBuilder.append(mEmptyTag.group());
                stringBuilder.append("---------EMPTY\n");
            }

        }


        return stringBuilder;
    }
}
