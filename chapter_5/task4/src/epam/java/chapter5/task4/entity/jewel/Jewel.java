package epam.java.chapter5.task4.entity.jewel;

import epam.java.chapter5.task4.entity.material.Gem;
import epam.java.chapter5.task4.entity.material.Metal;
import epam.java.chapter5.task4.entity.material.Wood;

import java.util.Arrays;

public class Jewel {
    private String name;
    private Gem[] gems;
    private Metal[] metals;
    private Wood[] woods;
    private double price;

    public Jewel(String name, Gem[] gems, Metal[] metals, Wood[] woods) {
        this.name = name;
        this.gems = gems;
        this.metals = metals;
        this.woods = woods;

        double jewelPrice = 0.0;

        for (Gem g: gems) {
            jewelPrice += g.getPrice();
        }

        for (Wood w: woods) {
            jewelPrice += w.getPrice();
        }

        for (Metal m: metals) {
            jewelPrice += m.getPrice();
        }

        this.price = jewelPrice;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  name + " / " +
                ", gems=" + Arrays.toString(gems) +
                ", metals=" + Arrays.toString(metals) +
                ", woods=" + Arrays.toString(woods) +
                ", price=" + price;
    }
}
