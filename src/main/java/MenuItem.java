/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanas
 */
public class MenuItem {
    private final String itemName;
    private final double price;
    

    public MenuItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }
    
}

