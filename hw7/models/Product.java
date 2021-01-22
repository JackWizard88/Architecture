public class Product {

    private static long counter = 1;
    private long id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.id = counter++;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("\n id: %s | name: %s | price: %s ", id, name, price);
    }
}