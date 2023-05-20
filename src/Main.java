import entities.Customer;
import entities.GoldCustomer;
import entities.Product;
import entities.RegularCustomer;
import entities.enums.ProductTypes;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RetailCompany retailCompany = new RetailCompany();

        // Add products to the retail company
        Product product1 = new Product(1, "Apple", 10.0, ProductTypes.FOOD, false, 8.0, 2.0);
        Product product2 = new Product(2, "iphone", 20000.0, ProductTypes.ELECTRONIC, true, 18.0, 3.0);
        Product product3 = new Product(3, "Samsung", 15000.0, ProductTypes.ELECTRONIC, true, 18.0, 5.0);
        retailCompany.addProduct(product1);
        retailCompany.addProduct(product2);
        retailCompany.addProduct(product3);

        // Add customers to the retail company
        Customer customer1 = new RegularCustomer("Ahmet", 1);
        Customer customer2 = new GoldCustomer("Mehmet", 2);
        retailCompany.addCustomer(customer1);
        retailCompany.addCustomer(customer2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product and amount pairs:");
        System.out.println("<product_id> <amount>");

        while (true) {
            try {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length != 2) {
                    System.out.println("Invalid input");
                    continue;
                }

                int productId = Integer.parseInt(parts[0]);
                int amount = Integer.parseInt(parts[1]);

                retailCompany.addProductToBasket(productId, amount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Enter product and amount (or enter 0 to finish):");
            System.out.println("<product_id> <amount> (or enter 0 to finish)");
            String line = scanner.nextLine();
            if (line.equals("0")) {
                break;
            }
        }

        System.out.println("Basket:");
        List<Product> basket = retailCompany.getBasket();
        for (Product product : basket) {
            System.out.println(product);
        }

        System.out.println("Enter customer ID:");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        Customer customer = retailCompany.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("No customer found with ID: " + customerId);
            return;
        }

        Transaction transaction = retailCompany.buy(customer);
        System.out.println("Transaction completed.");
        System.out.println("Customer: " + transaction.getCustomer());
        System.out.println("Total Amount: " + transaction.getTotalAmount());
    }}