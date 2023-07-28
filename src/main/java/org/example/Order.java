package org.example;

public class Order {

    private Customer customer;
    private Product product;
    private int amount;

    private int orderPrice;

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    private static int counter;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public static int getCounter() {
        return counter;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order(Customer customer, Product product, int amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        counter++;
    }

    @Override
    public String toString() {
        return "Order( " +
                "customer: " + customer.getName() +
                ", product: " + product.getName() +
                ", price with dicount: " + getOrderPrice() +
                ", amount: " + getAmount() + ")";
    }
}
