package epam.java.chapter5.task5.entity.present;

import epam.java.chapter5.task5.action.PresentAction;
import epam.java.chapter5.task5.entity.package_type.PackageType;
import epam.java.chapter5.task5.entity.sweets.Biscuits;
import epam.java.chapter5.task5.entity.sweets.Chocolate;
import epam.java.chapter5.task5.entity.sweets.Marshmallow;

public class PresentBuilderClass implements PresentBuilder {
    private Present present = new Present();
    private PresentAction presentAction = new PresentAction();

    @Override
    public PresentBuilder withChocolate(String name, double price) {
        if (presentAction.checkComponentParams(name, price)) {
            present.setChocolate(new Chocolate(name, price));
        }
        return this;
    }

    @Override
    public PresentBuilder withMarshmallow(String name, double price) {
        if (presentAction.checkComponentParams(name, price)) {
            present.setMarshmallow(new Marshmallow(name, price));
        }
        return this;
    }

    @Override
    public PresentBuilder withBiscuits(String name, double price) {
        if (presentAction.checkComponentParams(name, price)) {
            present.setBiscuits(new Biscuits(name, price));
        }
        return this;
    }

    @Override
    public PresentBuilder withPackageType(PackageType packageType) {
        present.setPackageType(packageType);
        return this;
    }

    @Override
    public Present buildPresent() {
        double currPrice;

        currPrice = present.getBiscuits().getPrice()
                + present.getChocolate().getPrice()
                + present.getMarshmallow().getPrice()
                + present.getPackageType().getPrice();

        present.setPrice(currPrice);

        return present;
    }
}
