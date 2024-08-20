package list.basictasks;

public class Item {

    private String name;

    private double price;

    private double quantify;

    public Item(String name, double price, double quantify) {
        this.name = name;
        this.price = price;
        this.quantify = quantify;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantify() {
        return quantify;
    }

}
