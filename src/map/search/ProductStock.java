package map.search;

import java.util.HashMap;
import java.util.Map;

public class ProductStock {

    private Map<Long, Products> stockProductsMap;

    public ProductStock() {
        this.stockProductsMap = new HashMap<>();
    }

    public void addProducts(long code, String name, int amount, double price) {
        stockProductsMap.put(code, new Products(name, code, amount, price));
    }

    public void displayProducts() {
        System.out.println(stockProductsMap);
    }

    public double calculateTotalValueStock() {
        double valueTotal = 0d;
        if (!stockProductsMap.isEmpty()) {
            for (Products p : stockProductsMap.values()) {
                valueTotal += p.getPrice() * p.getAmount();
            }
        }
        return valueTotal;
    }

    public Products getProductMoreExpensive() {
        Products productsMoreExpensive = null;
        double biggerPrice = Double.MIN_VALUE;
        for (Products p : stockProductsMap.values()) {
            if (p.getPrice() > biggerPrice) {
                productsMoreExpensive = p;
                biggerPrice = p.getPrice();
            }
        }
        return productsMoreExpensive;
    }

    public Products getProductLessExpensive() {
        Products productsLessExpensive = null;
        double theCheapest = Double.MAX_VALUE;
        for (Products p : stockProductsMap.values()) {
            if (p.getPrice() < theCheapest) {
                productsLessExpensive = p;
                theCheapest = p.getPrice();
            }
        }
        return productsLessExpensive;
    }

    public Products getProductLargestQuantityTotalValueInStock() {
        Products productsBiggerInStock = null;
        double theBiggerInStock = Double.MIN_VALUE;
        if (!stockProductsMap.isEmpty()) {
            for (Map.Entry<Long, Products> entry : stockProductsMap.entrySet()) {
                double valueProductInStock = entry.getValue().getAmount();
                if (valueProductInStock > theBiggerInStock) {
                    theBiggerInStock = valueProductInStock;
                    productsBiggerInStock = entry.getValue();
                }
            }
        }
        return productsBiggerInStock;
    }

    public Products getProductSmallerQuantityTotalValueStock() {
        Products productsSmallerInStock = null;
        double theSmallerInStock = Double.MAX_VALUE;
        if (!stockProductsMap.isEmpty()) {
            for (Map.Entry<Long, Products> entry : stockProductsMap.entrySet()) {
                double amountProductInStock = entry.getValue().getAmount();
                if (amountProductInStock < theSmallerInStock) {
                    theSmallerInStock = amountProductInStock;
                    productsSmallerInStock = entry.getValue();
                }
            }
        }

        return productsSmallerInStock;
    }


    public static void main(String[] args) {
        ProductStock productStock = new ProductStock();

        productStock.addProducts(1L, "Milk", 54, 5.00);
        productStock.addProducts(5L, "Yogurt", 59, 10.00);
        productStock.addProducts(2L, "Chocolate", 20, 15.00);
        productStock.addProducts(3L, "cookie", 36, 6.00);
        productStock.addProducts(4L, "Coffee", 62, 30.00);

        System.out.println("Showing all products: ");
        productStock.displayProducts();
        System.out.println("-----------------------");

        System.out.println("Calculating the total value of inventory: ");
        System.out.println("R$" + productStock.calculateTotalValueStock());
        System.out.println("----------------------------------------");

        System.out.println("Getting the product more expensive in inventory: ");
        System.out.println(productStock.getProductMoreExpensive());
        System.out.println("--------------------------------");

        System.out.println("Getting the cheapest product in inventory: ");
        System.out.println(productStock.getProductLessExpensive());
        System.out.println("--------------------------------");

        System.out.println("Obtaining the product in greater quantity: ");
        System.out.println(productStock.getProductLargestQuantityTotalValueInStock());
        System.out.println("-------------------------------");

        System.out.println("Obtaining the product in smaller quantity: ");
        System.out.println(productStock.getProductSmallerQuantityTotalValueStock());


    }
}