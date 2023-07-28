package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Controller {
    ArrayList<Order> orders;

    ArrayList<Product> stock;
    ArrayList<Customer> customers;
    public Controller(ArrayList<Customer> customers, ArrayList<Product> stock, ArrayList<Order> orders) {
        this.stock = stock;
        this.customers = customers;
        this.orders = orders;
    }

    public Order checkout(String customer, String product, int amount) throws NoSuchCustomerException, NoSuchItemrException, IllegalAmountException {
        if (!(amount > 0)) throw new IllegalAmountException("Wrong amount of the product.");

        Customer cust = null;
        Product prod = null;

        for (Customer item : customers) {
            if (customer.equals(item.getName())) {
                cust = item;
                break;
            }
        }

        if (cust == null) throw new NoSuchCustomerException("No such customer found.");

        for (Product value : stock) {
            if (product.equals(value.getName())) {
                prod = value;
                break;
            }
        }

        if (prod == null) throw new NoSuchItemrException("No such product found.");

        return new Order(cust, prod, amount);
    }

    public int getRandom()
    {
        Random rand = new Random();

        return rand.nextInt(((5-1)+1) + 1);
    }

    public void calculateWithDiscounts() throws TooMuchSaleException {
        int discountAmount = 0;

        for (int i = 0; i < TypesOfProducts.values().length; i++)
        {
            for (Product p : stock)
            {
                if (p.getType() == i + 1) {
                    int discount = Sales.getSalePercent(getRandom());
                    discountAmount += discount;
                    if (!(discountAmount >= 50)) {
                        p.setPrice(p.getPrice() - p.getPrice() / 100 * discount);
                    }
                    else { throw new TooMuchSaleException("Too much sale for your items. Your discount will be 20%");
                    }
                }

            }
        }
    }

    public void setOrderPrice()
    {
        for (Order o : orders)
        {
            for (Product p : stock)
            {
                if (o.getProduct().getName().equals(p.getName()))
                {
                    o.setOrderPrice(p.getPrice());
                }
            }
        }
    }
}
