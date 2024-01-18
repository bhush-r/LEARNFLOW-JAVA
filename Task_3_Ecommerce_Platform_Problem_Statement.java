import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }
}

class Order {
    private static int orderIdCounter = 1;

    private int orderId;
    private ShoppingCart cart;

    public Order(ShoppingCart cart) {
        this.orderId = orderIdCounter++;
        this.cart = cart;
    }

    public int getOrderId() {
        return orderId;
    }

    public ShoppingCart getCart() {
        return cart;
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }
}

class ECommercePlatform {
    private List<Product> productList;
    private List<Order> orderList;
    private Map<String, User> userMap;

    public ECommercePlatform() {
        this.productList = new ArrayList<>();
        this.orderList = new ArrayList<>();
        this.userMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void registerUser(String username, String password) {
        User user = new User(username, password);
        userMap.put(username, user);
    }

    public User authenticateUser(String username, String password) {
        User user = userMap.get(username);
        if (user != null && user.authenticate(password)) {
            return user;
        }
        return null;
    }

    public void displayProducts() {
        System.out.println("Product Listing:");
        for (Product product : productList) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    public Order processOrder(User user, ShoppingCart cart) {
        Order order = new Order(cart);
        orderList.add(order);
        return order;
    }

    // Getter for productList
    public List<Product> getProductList() {
        return productList;
    }
}

public class Task_3_Ecommerce_Platform_Problem_Statement {
    public static void main(String[] args) {
        ECommercePlatform eCommercePlatform = new ECommercePlatform();

        // Adding products
        eCommercePlatform.addProduct(new Product("Laptop", 999.99));
        eCommercePlatform.addProduct(new Product("Smartphone", 499.99));
        eCommercePlatform.addProduct(new Product("Headphones", 79.99));

        // Registering users
        eCommercePlatform.registerUser("user1", "password1");
        eCommercePlatform.registerUser("user2", "password2");

        // Simulating user authentication
        User authenticatedUser = eCommercePlatform.authenticateUser("user1", "password1");

        if (authenticatedUser != null) {
            // Simulating product selection and adding to cart
            ShoppingCart cart = new ShoppingCart();
            cart.addItem(eCommercePlatform.getProductList().get(0), 2);
            cart.addItem(eCommercePlatform.getProductList().get(1), 1);

            // Displaying products in the cart
            System.out.println("Products in the cart:");
            for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(product.getName() + " - Quantity: " + quantity);
            }

            // Processing the order
            Order order = eCommercePlatform.processOrder(authenticatedUser, cart);
            System.out.println("Order placed successfully! Order ID: " + order.getOrderId());
        } else {
            System.out.println("Invalid credentials. Authentication failed.");
        }
    }
}
