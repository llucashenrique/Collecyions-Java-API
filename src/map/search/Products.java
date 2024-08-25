package map.search;

public class Products {

    private String name;

    private long code;

    private int amount;

    private double price;

    public Products(String name, long code, int amount, double price) {
        this.name = name;
        this.code = code;
        this.amount = amount;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public long getCode() {
        return code;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return " Products Name: " + name + ", Code: " + code + ", Amount: " + amount+ " " + ", Price: " + price + " ";
    }
}
