package org.example;

public class Main {
    public static void main(String[] args) {
        int number = -2;

        long result = FactorialCalculator.factorial(number);
        System.out.println("Факториал числа " + number + " равен " + result);
    }
}
