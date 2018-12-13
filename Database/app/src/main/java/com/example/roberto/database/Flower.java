package com.example.roberto.database;

public class Flower {
    private String category;
    private double price;
    private String instructions;
    private String photo;
    private String name;
    private long productID;

    public Flower(){}

    public Flower(String category, double price, String instructions, String photo, String name, long productID) {
        this.category = category;
        this.price = price;
        this.instructions = instructions;
        this.photo = photo;
        this.name = name;
        this.productID = productID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "category='" + category + '\'' +
                ", price=" + price +
                ", instructions='" + instructions + '\'' +
                ", photo='" + photo + '\'' +
                ", name='" + name + '\'' +
                ", productID=" + productID +
                '}';
    }
}
