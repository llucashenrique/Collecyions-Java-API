package set.ordering;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RegisterProduct {

    private Set<Product> productSet;

    public RegisterProduct() {
        this.productSet = new HashSet<>();
    }

    public void addProduct(long cod, String nome, double price, int amount) {
        productSet.add(new Product(cod, nome, price, amount));
    }

    public Set<Product> displayProductsByName() {
        Set<Product> productsByName = new TreeSet<>(productSet);
        return productsByName;
    }

    public Set<Product> displayProductsByPrice() {
        Set<Product> productsByPrice = new TreeSet<>(new ComparatorByPrice());
        productsByPrice.addAll(productSet);
        return productsByPrice;
    }

    public static void main(String[] args) {
        RegisterProduct registerProduct = new RegisterProduct();

        registerProduct.addProduct(1L, "Product 01", 5.00, 5);
        registerProduct.addProduct(2L, "Product 02", 10.00, 10);
        registerProduct.addProduct(1L, "Product 03", 7.70, 11);
        registerProduct.addProduct(4L, "Product 04", 15.78, 9);

        System.out.println("Showing all products of List: ");
        System.out.println(registerProduct.productSet);
        System.out.println("----------------------------");

        System.out.println("Showing products by name: ");
        System.out.println(registerProduct.displayProductsByName());
        System.out.println("-----------------------------");

        System.out.println("Showing products by price: ");
        System.out.println(registerProduct.displayProductsByPrice());
    }
}
