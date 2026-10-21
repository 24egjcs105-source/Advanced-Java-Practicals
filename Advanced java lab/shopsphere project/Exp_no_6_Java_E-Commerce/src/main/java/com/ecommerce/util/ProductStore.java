package com.ecommerce.util;

import com.ecommerce.model.Product;
import java.util.List;

public final class ProductStore {
    private ProductStore(){}
    private static final List<Product> PRODUCTS = List.of(
        new Product(1,"Wireless Headphones","Clear sound, comfy fit and long battery life","Electronics",1499,"🎧"),
        new Product(2,"Smart Watch","Everyday fitness and notification tracking","Electronics",2299,"⌚"),
        new Product(3,"Running Shoes","Lightweight shoes for daily use","Fashion",1799,"👟"),
        new Product(4,"Backpack","Roomy backpack for college and travel","Accessories",999,"🎒"),
        new Product(5,"Coffee Maker","Brew your morning coffee at home","Home",2499,"☕"),
        new Product(6,"Desk Lamp","Modern LED lamp for your study table","Home",699,"💡")
    );
    public static List<Product> all(){ return PRODUCTS; }
    public static Product find(int id){ return PRODUCTS.stream().filter(p->p.getId()==id).findFirst().orElse(null); }
}