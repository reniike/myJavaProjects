package checkOutApp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CheckoutServer {
    public static Scanner input = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();

    static ArrayList<String> item = new ArrayList<>();
    static ArrayList<Integer> quantity = new ArrayList<>();
    static ArrayList<Double> price = new ArrayList<>();
    private double userDiscount;
    private String cashierName;
    private String customerName;
    private final double VAT = 0.1750;
    private double amountGiven;

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void customerName() {
        System.out.println("What is the customer's name? ");
        customerName = input.nextLine();
        setCustomerName(customerName);
    }

    public void details() {
        System.out.println("What did the user buy? ");
        item.add(input.nextLine());

        System.out.println("How many pieces? ");
        quantity.add(input.nextInt());

        System.out.println("How much per unit? ");
        price.add(input.nextDouble());

        moreItems();
    }

    public void moreItems() {
        System.out.println("Add more items? Yes/No");
        String more = input.nextLine();
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void cashierName() {
        System.out.println("What is your name? ");
        cashierName = input.next();
        setCashierName(cashierName);
    }

    public void cashierDetails() {
        cashierName();
        System.out.println("How much discount will he get? ");
        userDiscount = input.nextDouble();
    }

    public double sumTotal() {
        double total = 0;
        for (double price : price)
            total += price;
        return total;
    }

    public void receipt() {
        String items = "ITEM";
        String qty = "Qty";
        String prices = "PRICE";
        String total = "TOTAL(NGN)";

        System.out.printf("""
                        SEMICOLON STORES
                        MAIN BRANCH
                        LOCATION: 312, HERBERT MACAULAY WAY, SABO  YABA, LAGOS STATE
                        TEL: 00928611699
                        %s
                        CASHIER NAME: %s
                        CUSTOMER'S NAME: %s
                        %s
                        %18s %11s %11s %15s
                        %s
                        """, formatter.format(date), getCashierName(), getCustomerName(), "=".repeat(60),
                items, qty, prices, total, "-".repeat(60));
        display();

    }

    public double total(double price, int quantity) {
        return price * quantity;
    }

    public double subTotal() {
        double subTotal = 0.00;
        for (int index = 0; index < price.size(); index++) {
            subTotal += total(price.get(index), quantity.get(index));
        }
        return subTotal;
    }

    public double discount() {
        return userDiscount / 100 * subTotal();
    }

    public double vat() {
        double vat = VAT * subTotal();
        return vat;
    }

    public double billTotal() {
        double billTotal = subTotal() + vat() - discount();
        return billTotal;
    }

    public void display() {

        String sum = "SUB TOTAL:";
        String discount = "DISCOUNT:";
        String vat = "VAT @ 17.50%:";
        String billTotal = "BILL TOTAL:";

        for (int index = 0; index < item.size(); index++) {
            int theQuantity = quantity.get(index);
            double thePrice = price.get(index);
            System.out.printf("%18s %11s %11s %15s%n", item.get(index), theQuantity, thePrice, total(thePrice,
                    theQuantity));
        }
        System.out.printf("""
                        %s
                        %30s%15s
                        %30s%15s
                        %30s%15s
                        %s
                        %30s%15s
                        %s
                        """, "-".repeat(60), sum, subTotal(), discount, discount(), vat, vat(), "=".repeat(60),
                billTotal, billTotal(), "=".repeat(60));
        System.out.printf("THIS IS NOT A RECEIPT , KINDLY PAY %s%n %s%n ", billTotal(), "=".repeat(60));
    }
}
