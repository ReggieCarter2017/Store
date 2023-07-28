package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> stock = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        customers.add(new Customer("John", 10000));
        customers.add(new Customer("Paul", 10000));
        customers.add(new Customer("Erick", 25000));
        customers.add(new Customer("Vladimir", 70000));
        customers.add(new Customer("Elza", 50000));

        stock.add(new Product("Computer", 20000, 2));
        stock.add(new Product("Display", 5000, 2));
        stock.add(new Product("Banana", 500, 1));
        stock.add(new Product("Soap bar", 100, 3));




        Controller a = new Controller(customers, stock, orders);


        try {
            orders.add(a.checkout("Vladimir", "Display", 1));
            orders.add(a.checkout("John", "Computer", 1));
            orders.add(a.checkout("Elza", "Banana", 1));
            orders.add(a.checkout("Erick", "Soap bar", 2));
            orders.add(a.checkout("John", "Soap bar", 1));
        } catch (NoSuchCustomerException | NoSuchItemrException | IllegalAmountException e) {
            System.out.println(e.getMessage());
        }


        try {
            a.calculateWithDiscounts();
        } catch (TooMuchSaleException e) {
            System.out.println(e.getMessage());
        }
        a.setOrderPrice();
        for (Order o : orders) System.out.println(o.toString());







    }
}