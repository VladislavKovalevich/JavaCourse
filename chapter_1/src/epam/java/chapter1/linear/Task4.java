package epam.java.chapter1.linear;

/**
 * Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
 * дробную и целую части числа и вывести полученное значение числа.
 */
public class Task4 {
    public static void main(String[] args){
        double value;

        int intValue;
        int modValue;
        double resValue;

        value = 765.698;

        intValue = (int) value;
        modValue = (int)(value * 1000 - intValue * 1000);
        resValue = ((double)intValue / 1000) + modValue;

        System.out.println("Результат = " + resValue);
    }
}
