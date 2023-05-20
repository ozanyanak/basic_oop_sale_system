package entities;

public class RegularCustomer extends Customer{
    private double transaction_promotion_rate=0.002;

    public RegularCustomer(String name, int id) {
        super(name, id);
    }
    public double getTransaction_promotion_rate(){
        return transaction_promotion_rate;
    }
}
