package epam.java.chapter5.task5.action;

public class PresentAction {

    public PresentAction(){

    }

    public boolean checkComponentParams(String name, double price){
        if (!name.matches("[a-zA-Z]{4,25}([\\s])?([a-zA-Z]{4,25})?")){
            System.out.println("Некорректное название сладости");
            return false;
        }else{
            if (price <= 0){
                System.out.println("Значение стоимости должно быть больше нуля");
                return false;
            }else{
                return true;
            }
        }
    }
}
