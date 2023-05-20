package entities;

public class GoldCustomer extends Customer {
    private double transaction_promotion_rate=0.005;

    public GoldCustomer(String name, int id) {
        super(name, id);
    }
    public double getTransaction_promotion_rate(){
        return transaction_promotion_rate;
    }
}
