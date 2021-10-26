package epam.java.chapter5.task4;

import epam.java.chapter5.task4.action.TreasureCaveAction;
import epam.java.chapter5.task4.entity.TreasureCave;
import epam.java.chapter5.task4.entity.jewel.Jewel;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 * • Приложение должно быть объектно-, а не процедурно-ориентированным.
 * • Каждый класс должен иметь отражающее смысл название и информативный состав.
 * • Наследование должно применяться только тогда, когда это имеет смысл.
 * • При кодировании должны быть использованы соглашения об оформлении кода java code convention.
 * • Классы должны быть грамотно разложены по пакетам.
 * • Консольное меню должно быть минимальным.
 * • Для хранения данных можно использовать файлы.
 *
 * Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
 * дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
 * выбора сокровищ на заданную сумму.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner;
        TreasureCave treasureCave;
        TreasureCaveAction treasureCaveAction;

        treasureCave = new TreasureCave(100);
        treasureCaveAction = new TreasureCaveAction();

        scanner = new Scanner(System.in);

        int code = 1;

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
                        treasureCaveAction.printAllJewels(treasureCave);
                        break;
                    }
                    case 3:{
                        System.out.println(treasureCaveAction.getMostExpensive(treasureCave));
                        break;
                    }
                    case 4:{
                        double amount;

                        System.out.println("Ввведите сумму:");
                        amount = scanner.nextDouble();

                        for (Jewel j : treasureCaveAction.getJewelForAmount(treasureCave, amount)) {
                            System.out.println(j);
                        }

                        break;
                    }
                }

            }catch (InputMismatchException ex){
                System.out.println("Некорректный ввод данных");
            }
        }

        System.out.println("Завершение работы приложения");
    }

    private static void getDocumentation() {
        System.out.println("\n0 - выход\n" +
                "1 - список команд\n" +
                "2 - получить список сокровищ\n" +
                "3 - получить самое дорогое сокровище\n" +
                "4 - получить список сокровищ на заданную сумму\n");
    }
}
