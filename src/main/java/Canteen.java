/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanas
 */
import java.util.List;
import java.util.ArrayList;

public class Canteen {
    private List<User> users;
    private List<MenuItem> menu;
    private List<Order> orders;

    public Canteen() {
        this.users = new ArrayList<>();
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void registerUser(String username, String password) {
        users.add(new User(username, password));
    }

    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.authenticate(password) && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void displayMenu() {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getItemName() + " - Rs " + menu.get(i).getPrice());
        }
    }

    public void placeOrder(User user, Order order) {
        orders.add(order);
        System.out.println("Order placed successfully. Your token number is: " + orders.size());
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public List<Order> getOrders() {
        return orders;
    }
    
}

