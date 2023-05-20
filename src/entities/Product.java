package entities;

import entities.enums.ProductTypes;

public class Product {
    private int id;
    private String name;
    private double basePrice;
    private ProductTypes type;
    private boolean isLuxury;
    private double vat;
    private double productPromotion;

    public Product(int id, String name, double basePrice, ProductTypes type, boolean isLuxury, double vat, double productPromotion) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.type = type;
        this.isLuxury = isLuxury;
        this.vat = vat;
        this.productPromotion = productPromotion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public ProductTypes getType() {
        return type;
    }

    public void setType(ProductTypes type) {
        this.type = type;
    }

    public boolean isLuxury() {
        return isLuxury;
    }

    public void setLuxury(boolean luxury) {
        isLuxury = luxury;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getProductPromotion() {
        return productPromotion;
    }

    public void setProductPromotion(double productPromotion) {
        this.productPromotion = productPromotion;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
