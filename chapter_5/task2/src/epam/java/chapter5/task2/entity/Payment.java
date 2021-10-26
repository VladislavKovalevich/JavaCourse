package epam.java.chapter5.task2.entity;

public class Payment {
    private Product[] products;

    public Payment(Product ...products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (products.length <= 0){
            stringBuilder.append("Чек пуст");
        }else{
            double totalPrice = 0;

            for (Product p : products) {
                stringBuilder.append(p).append("\n");
                totalPrice += p.price * p.count;
            }

            stringBuilder.append("\n");
            stringBuilder.append("Итог: ").append(totalPrice);
        }

        return stringBuilder.toString();
    }

    public class Product {
        private String name;
        private double price;
        private int count;

        public Product(String name, double price, int count) {
            this.name = name;
            this.price = price;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {

            return name + " _____ " +
                    price + " * " +
                    count + " шт. = " +
                    count * price + " ";
        }
    }
}
