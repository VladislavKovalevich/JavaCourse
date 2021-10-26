package epam.java.chapter1.linear;

/**
 * Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
 * дробную и целую части числа и вывести полученное значение числа.
 */
public class Task4 {
    public static void main(String[] args){
        double value = 765.698;

        int intValue = (int) value;

        int modValue = (int)(value* 1000 - intValue* 1000);

        double resValue = ((double)intValue / 1000) + modValue;

        System.out.println("Результат = "+ resValue);
    }
}
