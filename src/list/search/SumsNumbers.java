package list.search;

import java.util.ArrayList;
import java.util.List;

public class SumsNumbers {


    private List<Integer> numbers;

    public SumsNumbers() {
        this.numbers = new ArrayList<>();
    }


    public void addNumbers(int number) {
        this.numbers.add(number);
    }

    public int sumsNumbers() {
        int sum = 0;
        for (Integer i : numbers) {
            sum += i;
        }
        return sum;
    }


    public Integer findBiggestNumber() {

        int biggestNumber = Integer.MIN_VALUE;

        if (!numbers.isEmpty()) {
            for (Integer i : numbers) {
                if (i >= biggestNumber) {
                    biggestNumber = i;
                }
            }
            return biggestNumber;
        } else {
            throw new RuntimeException("List is empty");
        }
    }

    public Integer findSmallestNumber() {

        int smallestNumber = Integer.MAX_VALUE;

        if (!numbers.isEmpty()) {
            for (Integer i : numbers) {
                if (i <= smallestNumber) {
                    smallestNumber = i;
                }
            }
            return smallestNumber;
        } else {
            throw new RuntimeException("List is empty");
        }
    }

    public void displayNumbers() {
        if (!numbers.isEmpty()) {
            System.out.println(this.numbers);
        } else {
            System.out.println("List is empty");
        }
    }

    public static void main(String[] args) {
        SumsNumbers sumsNumbers = new SumsNumbers();

        sumsNumbers.addNumbers(10);
        sumsNumbers.addNumbers(10);
        sumsNumbers.addNumbers(12);
        sumsNumbers.addNumbers(13);
        sumsNumbers.addNumbers(-13);

        System.out.println("Sums of numbers: " + sumsNumbers.sumsNumbers());
        System.out.println("Find the smallest number of list: " + sumsNumbers.findSmallestNumber());
        System.out.println("Find the biggest number of list: " + sumsNumbers.findBiggestNumber());

    }
}
