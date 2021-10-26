package epam.java.chapter5.task4.action;

import epam.java.chapter5.task4.entity.TreasureCave;
import epam.java.chapter5.task4.entity.jewel.Jewel;

import java.util.ArrayList;
import java.util.List;

public class TreasureCaveAction {

    public TreasureCaveAction() {
    }

    public Jewel getMostExpensive(TreasureCave treasureCave){
        double max = treasureCave.getJewels().get(0).getPrice();
        Jewel jewelProduct = treasureCave.getJewels().get(0);

        for (Jewel j: treasureCave.getJewels()) {
            if (max < j.getPrice()){
                max = j.getPrice();
                jewelProduct = j;
            }
        }

        return jewelProduct;
    }

    public void printAllJewels(TreasureCave treasureCave){
        for (Jewel j : treasureCave.getJewels()) {
            System.out.println(j);
        }
    }

    public List<Jewel> getJewelForAmount(TreasureCave treasureCave, double amount){
        List<Jewel> jewelProducts = new ArrayList<>();

        for (Jewel j : treasureCave.getJewels()) {
            if (j.getPrice() <= amount){
                jewelProducts.add(j);
                amount -= j.getPrice();
            }
        }

        return jewelProducts;
    }
}
