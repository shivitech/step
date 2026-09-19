import java.util.Scanner;

public class ProductInventoryCSVParser {

    // Parses a CSV line into Product, SKU, and Quantity fields
    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String product = fields[0];
        String sku = fields[1];
        String qty = fields[2];

        System.out.println("Product: " + product + " | SKU: " + sku + " | Qty: " + qty);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter CSV line: ");
        String csvLine = sc.nextLine();

        parseInventoryRecord(csvLine);

        sc.close();
    }
}