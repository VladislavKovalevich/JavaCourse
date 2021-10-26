package epam.java.chapter5.task5.entity.present;

import epam.java.chapter5.task5.entity.package_type.PackageType;
import epam.java.chapter5.task5.entity.sweets.Biscuits;
import epam.java.chapter5.task5.entity.sweets.Chocolate;
import epam.java.chapter5.task5.entity.sweets.Marshmallow;

public class Present {
    private Biscuits biscuits;
    private Marshmallow marshmallow;
    private Chocolate chocolate;
    private PackageType packageType;
    private double price;

    public Present(){
    }

    public void setBiscuits(Biscuits biscuits) {
        this.biscuits = biscuits;
    }

    public void setMarshmallow(Marshmallow marshmallow) {
        this.marshmallow = marshmallow;
    }

    public void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public Marshmallow getMarshmallow() {
        return marshmallow;
    }

    public Biscuits getBiscuits() {
        return biscuits;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Present: " +
                biscuits +
                marshmallow +
                chocolate +
                "packageType = " + packageType + " / " + packageType.getPrice() +
                "\nprice = " + price;
    }
}
