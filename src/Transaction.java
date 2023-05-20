import entities.Customer;
import entities.Product;

import java.util.List;

public class Transaction {
    private Customer customer;
    private List<Product> basket;
    private double totalAmount;

    public Transaction(Customer customer, List<Product> basket, double totalAmount) {
        this.customer = customer;
        this.basket = basket;
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getBasket() {
        return basket;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}