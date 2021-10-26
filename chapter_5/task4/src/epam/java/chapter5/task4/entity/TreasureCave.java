package epam.java.chapter5.task4.entity;

import epam.java.chapter5.task4.entity.jewel.Jewel;
import epam.java.chapter5.task4.entity.material.Gem;
import epam.java.chapter5.task4.entity.material.Metal;
import epam.java.chapter5.task4.entity.material.Wood;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreasureCave {
    private List<Jewel> jewels = new ArrayList<>();

    public TreasureCave(int treasuresCount){
        // генерация сокровищ
        Gem[] gems;
        Metal[] metals;
        Wood[] woods;

        Random r = new Random();

        for (int i = 0; i < treasuresCount; i++) {
            gems = new Gem[r.nextInt(4)];

            for (int j = 0; j < gems.length; j++) {
                gems[j] = new Gem("Камень " + j, r.nextDouble(), r.nextDouble());
            }

            metals = new Metal[r.nextInt(4)];

            for (int j = 0; j < metals.length; j++) {
                metals[j] = new Metal("Металл " + j, r.nextDouble(), r.nextDouble());
            }

            woods = new Wood[r.nextInt(4)];

            for (int j = 0; j < woods.length; j++) {
                woods[j] = new Wood("Древисина " + j, r.nextDouble(), r.nextDouble());
            }

            Jewel jewel;
            jewel = new Jewel("Сокровище" + i, gems, metals, woods);
            jewels.add(jewel);

        }
    }

    public TreasureCave(List<Jewel> jewels) {
        this.jewels = jewels;
    }

    public List<Jewel> getJewels() {
        return jewels;
    }
}
