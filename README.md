# basic_oop_sale_system
## Features

- Customers: There are different types of customers, such as RegularCustomer and GoldCustomer. Each customer has a name, ID, and points.
- Products: The system manages a list of products, each with an ID, name, base price, type, luxury status, VAT rate, and product promotion percentage.
- Basket: Customers can add products to their basket by specifying the product ID and the desired amount.
- Transactions: When a customer makes a purchase, a transaction is created that includes the customer, the list of products in the basket, and the total amount.
- Point Calculation: With each transaction, customers earn points based on the total amount spent.

## Usage

1. Start by creating a RetailCompany instance.
2. Add products to the company's product list using the `addProduct` method.
3. Add customers to the company's customer list using the `addCustomer` method.
4. Customers can add products to their basket using the `addProductToBasket` method, specifying the product ID and the amount.
5. Customers can make a purchase by calling the `buy` method, passing the customer ID.
6. The system will calculate the total amount, update the customer's points, and create a transaction object.
7. Access the list of transactions through the company's `getTransactions` method.
