package list.ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderNumbers {

    private List<Integer> numbers;


    public OrderNumbers() {
        this.numbers = new ArrayList<Integer>();
    }

    public void addNumber(int numbers) {
        this.numbers.add(numbers);
    }

    public List<Integer> sortAscending() {
        List<Integer> sortAscending = new ArrayList<>(this.numbers);
        if (!numbers.isEmpty()) {
            Collections.sort(sortAscending);
            return sortAscending;
        } else {
            throw new RuntimeException("The list is empty");
        }
    }

    public List<Integer> sortDescending() {
        List<Integer> sortDescending = new ArrayList<>(this.numbers);
        if (!numbers.isEmpty()) {
            sortDescending.sort(Collections.reverseOrder());
            return sortDescending;
        } else {
            throw new RuntimeException("The list is empty");
        }
    }

    public void displayNumbers() {
        if (!numbers.isEmpty()) {
            System.out.println(this.numbers);
        } else {
            System.out.println("The list numbers are empty");
        }
    }

    public static void main(String[] args) {
        OrderNumbers orderNumbers = new OrderNumbers();

        orderNumbers.addNumber(1);
        orderNumbers.addNumber(2);
        orderNumbers.addNumber(5);
        orderNumbers.addNumber(90);
        orderNumbers.addNumber(52);
        orderNumbers.addNumber(87);

        System.out.println("Showing without any comparator: ");
        orderNumbers.displayNumbers();

        System.out.println("Showing ascending list: ");
        System.out.println(orderNumbers.sortAscending());

        System.out.println("Showing list descending: ");
        System.out.println(orderNumbers.sortDescending());
    }
}
