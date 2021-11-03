package epam.java.chapter5.task5;

import epam.java.chapter5.task5.entity.package_type.PackageType;
import epam.java.chapter5.task5.entity.present.Present;
import epam.java.chapter5.task5.entity.present.PresentBuilderClass;

public class Main {
    public static void main(String[] args) {
        Present present;

        present = new PresentBuilderClass().withBiscuits("Cookies", 5.0)
                .withChocolate("Alpen Gold", 20.5)
                .withMarshmallow("Marshmallow", 15.5)
                .withPackageType(PackageType.PAPER)
                .buildPresent();

        System.out.println(present);
    }
}
