package set.ordering;

import java.util.Comparator;
import java.util.Objects;

public class Product implements Comparable<Product> {
    private long code;

    private String name;

    private double price;

    private int amount;

    public Product(long code, String name, double price, int amount) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public int compareTo(Product p) {
        return name.compareToIgnoreCase(p.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getCode() == product.getCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "{" + "Name: " + name + ", Code: " + code + ", Price: " + price + ", Amounts: " + amount + "}";
    }
}

class ComparatorByPrice implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}