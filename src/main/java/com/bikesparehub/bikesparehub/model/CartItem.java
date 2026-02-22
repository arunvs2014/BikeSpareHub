package com.bikesparehub.bikesparehub.model;

public class CartItem {

    private Long id;
    private String partName;
    private double price;
    private int quantity;

    public CartItem(Long id, String partName, double price, int quantity) {
        this.id = id;
        this.partName = partName;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public String getPartName() { return partName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}