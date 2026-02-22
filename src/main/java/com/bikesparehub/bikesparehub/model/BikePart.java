package com.bikesparehub.bikesparehub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "BIKE_PART")
public class BikePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partName;
    private String brand;
    private String model;
    private double price;
    private int stock;
    private String city;

    // Compatibility
    private String compatibleOldModel;

    // AI Category
    private String category;

    // Image
    private String imageUrl;

    // ===== Getters and Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompatibleOldModel() {
        return compatibleOldModel;
    }

    public void setCompatibleOldModel(String compatibleOldModel) {
        this.compatibleOldModel = compatibleOldModel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Stock Alert Logic
    public String getStockStatus() {
        return stock < 5 ? "LOW STOCK" : "AVAILABLE";
    }
}