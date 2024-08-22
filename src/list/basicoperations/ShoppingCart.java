package list.basicoperations;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(String name, double price, int quantity) {
        items.add(new Item(name, price, quantity));
    }

    public void remoteItem(String name, double price, int quantity) {
        List<Item> listForRemove = new ArrayList<>();
        if (!items.isEmpty()) {
            for (Item t : items) {
                if (t.getName().equalsIgnoreCase(name) && t.getPrice() == price && t.getQuantify() == quantity) {
                    listForRemove.add(t);
                }
            }
            items.removeAll(listForRemove);
        } else {
            System.out.println("No item found");
        }
    }

    double result = 0;

    public void calculateTotalValue() {

        for (Item item : items) {
            result += item.getPrice() * item.getQuantify();
        }
        if (items == null || items.isEmpty()) {
            System.out.println("No items found");
        }
        System.out.println("The total value in stock is " + result);
    }

    public int displayQuantifyItems() {
        return items.size();
    }

    public void displayItems() {
        for (Item item : items) {
            System.out.println("Name: " + item.getName());
            System.out.println("Quantify of items: " + item.getQuantify());
            System.out.println("The price of item: " + item.getPrice());
            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem("Shampoo", 12.50, 5);
        shoppingCart.addItem("Shampoo", 12.50, 5);
        shoppingCart.addItem("Sabonete", 3.40, 8);

        System.out.println("Quantification of items in stock "+shoppingCart.displayQuantifyItems());
        System.out.println("---------------------------------------");

        shoppingCart.displayItems();

        shoppingCart.calculateTotalValue();

    }

}
