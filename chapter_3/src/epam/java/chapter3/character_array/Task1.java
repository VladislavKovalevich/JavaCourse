package epam.java.chapter3.character_array;

import java.util.Arrays;

/**
 * Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */
public class Task1 {
    public static void main(String[] args) {
        String[] camelCaseArray;

        camelCaseArray = new String[]{"theHobbit", "theLordOfTheRings"};

        toSnakeCase(camelCaseArray);

        System.out.println(Arrays.toString(camelCaseArray));
    }

    private static void toSnakeCase(String[] array) {
        char currChar;

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length(); j++) {

                currChar = array[i].charAt(j);

                if (Character.isUpperCase(currChar)){
                    array[i] = getSnakeCaseString(array[i], j);
                }

            }

        }
    }

    private static String getSnakeCaseString(String s, int j) {
        String snakeCaseString;

        snakeCaseString = s.substring(0, j).concat("_").concat(s.substring(j, j+1).toLowerCase().concat(s.substring(j+1)));

        return snakeCaseString;
    }
}
