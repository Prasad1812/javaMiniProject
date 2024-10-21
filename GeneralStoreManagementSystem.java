package MiniProject;
import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String id;
    private String name;
    private double price;
    private int stock;

    public Item(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void showItem() {
        System.out.println("ID: " + id + ", Name : " + name + ", Price : " + price + "/-, Stock : " + stock);
    }
}

class Shop {
    private ArrayList<Item> items;
    private Scanner scanner;

    public Shop() {
        items = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nShop Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Show Items");
            System.out.println("4. Sell Item");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addItem(); break;
                case 2: updateItem(); break;
                case 3: showItems(); break;
                case 4: sellItem(); break;
                case 5: return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addItem() {
        System.out.print("\nEnter item ID : ");
        String id = scanner.nextLine();
        System.out.print("Enter item name : ");
        String name = scanner.nextLine();
        System.out.print("Enter item price : ");
        double price = scanner.nextDouble();
        System.out.print("Enter item stock : ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Item item = new Item(id, name, price, stock);
        items.add(item);
        System.out.println("\nItem added!");
    }

    private void updateItem() {
        System.out.print("\nEnter item ID to update: ");
        String id = scanner.nextLine();
        Item item = findItemById(id);
        if (item != null) {
            System.out.println("\n1. Update Stock");
            System.out.println("2. Update Price");
            System.out.println("3. Update Both");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter new stock : ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                    item.setStock(stock);
                    System.out.println("Stock updated!");
                    break;
                case 2:
                    System.out.print("\nEnter new price : ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    item.setPrice(price);
                    System.out.println("Price updated!");
                    break;
                case 3:
                    System.out.print("\nEnter new stock : ");
                    stock = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new price : ");
                    price = scanner.nextDouble();
                    scanner.nextLine();
                    item.setStock(stock);
                    item.setPrice(price);
                    System.out.println("Stock and price updated!");
                    break;
                default:
                    System.out.println("\nInvalid choice");
            }
        } else {
            System.out.println("\nItem not found");
        }
    }

    private void showItems() {
        System.out.println("\nItem List :");
        for (Item item : items) {
            item.showItem();
        }
    }

    private void sellItem() {
        System.out.print("\nEnter item ID to sell : ");
        String id = scanner.nextLine();
        Item item = findItemById(id);
        if (item != null) {
            System.out.print("Enter quantity to sell : ");
            int sellQty = scanner.nextInt();
            scanner.nextLine();

            if (sellQty <= item.getStock()) {
                double totalCost = sellQty * item.getPrice();
                item.setStock(item.getStock() - sellQty);
                System.out.println("Sold " + sellQty + " units of " + item.getName() + ". Total : " + totalCost + "/-");
            } else {
                System.out.println("\nNot enough stock");
            }
        } else {
            System.out.println("\nItem not found");
        }
    }

    private Item findItemById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}

public class GeneralStoreManagementSystem {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.run();
    }
}
