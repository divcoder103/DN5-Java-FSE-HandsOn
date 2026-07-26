
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Football", "Sports"),
                new Product(103, "Comb", "Fashion"),
                new Product(104, "Phone", "Electronics"),
                new Product(105, "Shoes", "Fashion")
        };

        // Search for existing product - Linear Search
        Product result1 = linearSearch(products, "Laptop");
        if (result1 != null) {
            System.out.println("Product found: " + result1.getProductName() + " | Category: " + result1.getCategory());
        } else {
            System.out.println("Product not found.");
        }

        // Search for non-existing product - Linear Search
        Product result2 = linearSearch(products, "Watch");
        if (result2 != null) {
            System.out.println("Product found: " + result2.getProductName() + " | Category: " + result2.getCategory());
        } else {
            System.out.println("Product not found.");
        }

        // Sort array before binary search
        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        // Search for existing product - Binary Search
        Product result3 = binarySearch(products, "Laptop");
        if (result3 != null) {
            System.out.println("Product found: " + result3.getProductName() + " | Category: " + result3.getCategory());
        } else {
            System.out.println("Product not found.");
        }

        // Search for non-existing product - Binary Search
        Product result4 = binarySearch(products, "Watch");
        if (result4 != null) {
            System.out.println("Product found: " + result4.getProductName() + " | Category: " + result4.getCategory());
        } else {
            System.out.println("Product not found.");
        }
    }

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p != null && p.getProductName().equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}