package epam.java.chapter6.task3.client.logic;

import java.util.Scanner;

public class ConsoleInputLogic {
    public ConsoleInputLogic(){

    }

    public int getIntDataFromConsole(String message, int minValue, int maxValue){
        int inputData;
        Scanner in;

        in = new Scanner(System.in);

        System.out.println(message);
        while(!in.hasNextInt()){
            System.out.println(message);
            in.next();
        }

        inputData = in.nextInt();
        in.nextLine();

        if (inputData >= minValue && inputData <= maxValue) {
            return inputData;
        }else{
            return getIntDataFromConsole(message, minValue, maxValue);
        }
    }

    public String getStringDataFromConsole(String message){
        String inputData;
        Scanner in;

        in = new Scanner(System.in);

        System.out.println(message);
        while(!in.hasNextLine()){
            System.out.println(message);
            in.next();
        }

        inputData = in.nextLine();

        return inputData;
    }
}
