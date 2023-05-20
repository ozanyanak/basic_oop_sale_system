import entities.Customer;
import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class RetailCompany {
    private List<Product> products;
    private List<Customer> customers;
    private List<Product> basket;

    public RetailCompany() {
        this.products = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.basket = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addProductToBasket(int productId, int amount) {
        Product product = getProductById(productId);

        if (product == null) {
            throw new IllegalArgumentException("No item with this ID. Please enter a valid product ID.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be negative. Please enter a positive amount.");
        }

        for (int i = 0; i < amount; i++) {
            basket.add(product);
        }

        System.out.println(amount + " " + product.getName() + "(s) added to the basket.");
    }

    public Transaction buy(Customer customer) {
        if (basket.isEmpty()) {
            throw new IllegalStateException("Basket is empty. Please add products to the basket before buying.");
        }

        double totalAmount = calculateTotalAmount();
        int pointsEarned = (int) Math.floor(totalAmount);
        customer.setPoints(customer.getPoints() + pointsEarned);
        Transaction transaction = new Transaction(customer, basket, totalAmount);
        clearBasket();

        return transaction;
    }

    private Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    private double calculateTotalAmount() {
        double amount = 0.0;
        for (Product product : basket) {
            double price = product.getBasePrice();
            double vat = product.getVat();
            double productPromotion =product.getProductPromotion();

            if (product.isLuxury()){
                amount +=(price + (price * vat / 100)+(price*vat/100)) * (1 - productPromotion / 100);

            }
            else {
                amount +=(price + (price * vat / 100)) * (1 - productPromotion / 100);

            }

        }
        return amount;
    }

    private void clearBasket() {
        basket.clear();
    }

    @Override
    public String toString() {
        return "RetailCompany{" +
                "products=" + products +
                ", customers=" + customers +
                ", basket=" + basket +
                '}';
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }

    public Customer getCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }


}
