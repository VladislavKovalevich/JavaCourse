package epam.java.chapter5.task5.entity.present;

import epam.java.chapter5.task5.entity.package_type.PackageType;

public interface PresentBuilder {
    PresentBuilder withChocolate(String name, double price);
    PresentBuilder withMarshmallow(String name, double price);
    PresentBuilder withBiscuits(String name, double price);
    PresentBuilder withPackageType(PackageType packageType);
    Present buildPresent();
}
