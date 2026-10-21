package com.ecommerce.model;

public class Product {
    private final int id;
    private final String name, description, category;
    private final double price;
    private final String emoji;

    public Product(int id, String name, String description, String category, double price, String emoji) {
        this.id=id; this.name=name; this.description=description; this.category=category; this.price=price; this.emoji=emoji;
    }
    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getDescription(){ return description; }
    public String getCategory(){ return category; }
    public double getPrice(){ return price; }
    public String getEmoji(){ return emoji; }
}