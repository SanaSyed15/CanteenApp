
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CanteenApp {
    public static void main(String[] args) {
        Canteen canteen = new Canteen();
        setupSampleData(canteen);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the College Canteen!");

        // Login
        User loggedInUser = login(scanner, canteen);
        if (loggedInUser != null) {
            // Display Menu
            canteen.displayMenu();

            // Place Order
            Order userOrder = placeOrder(scanner, canteen);
            if (userOrder != null) {
                canteen.placeOrder(loggedInUser, userOrder);
                
                double totalAmount=userOrder.calculateTotal();
                System.out.println("Thank you for placing the order.Your total is Rs "+totalAmount);
                      System.out.println( "Your token number is: " + canteen.getOrders().size());
            }
        } else {
            System.out.println("Invalid login credentials. Exiting...");
        }

        scanner.close();
    }

    private static User login(Scanner scanner, Canteen canteen) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        return canteen.loginUser(username, password);
    }

    private static Order placeOrder(Scanner scanner, Canteen canteen) {
        Order userOrder = new Order();

        while (true) {
            System.out.print("Enter the item number to add to your order (or type 'done' to finish): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int itemNumber = Integer.parseInt(userInput);
                if (itemNumber >= 1 && itemNumber <= canteen.getMenu().size()) {
                    userOrder.addItem(canteen.getMenu().get(itemNumber - 1));
                    System.out.println("Added " + canteen.getMenu().get(itemNumber - 1).getItemName() + " to your order.");
                } else {
                    System.out.println("Invalid item number. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid item number or 'done'.");
            }
        }

        return userOrder.getItems().isEmpty() ? null : userOrder;
    }

    private static void setupSampleData(Canteen canteen) {
        // Sample data for demonstration
        canteen.registerUser("Roylene", "password1");
        canteen.registerUser("Sana", "password2");
        canteen.registerUser("Faheem", "password3");
        canteen.registerUser("Zaid", "password4");

        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Burger", 50));
        menu.add(new MenuItem("Pizza", 100));
        menu.add(new MenuItem("Soda", 15));
        menu.add(new MenuItem("MasalaDosa", 30));
        menu.add(new MenuItem("Gobi", 50));
        menu.add(new MenuItem("Juice", 30));
        menu.add(new MenuItem("Fries", 25));

        canteen.setMenu(menu);
    }
}

