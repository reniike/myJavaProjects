package checkOutApp;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckOut {
    public static Scanner input = new Scanner(System.in);
    static ArrayList<String> item = new ArrayList<>();

    public static void main(String[] args) {
        CheckoutServer checkoutServer = new CheckoutServer();
        checkoutServer.customerName();
        checkoutServer.details();
        String more = input.next();
        while (more.equalsIgnoreCase("yes")) {
            checkoutServer.details();
            more = input.next();
        }
        checkoutServer.cashierDetails();
        System.out.println(
                """
                        
                        
                        
                        
                """
        );
        checkoutServer.receipt();
        System.out.println("HOW MUCH DID THE CUSTOMER GIVE YOU? ");
        double amountGiven = input.nextDouble();
        double balance = amountGiven - checkoutServer.billTotal();

        String sum = "SUB TOTAL:";
        String discount = "DISCOUNT:";
        String vat = "VAT @ 17.50%:";
        String billTotal = "BILL TOTAL:";
        for (int index = 0; index < item.size(); index++) {
            int theQuantity = CheckoutServer.quantity.get(index);
            double thePrice = CheckoutServer.price.get(index);
            System.out.printf("%18s %11s %11s %15s%n", item.get(index), theQuantity, thePrice, checkoutServer.total(thePrice, theQuantity));
        }
        System.out.printf("""
                %s
                %30s%15s
                %30s%15s
                %30s%15s
                %s
                %30s%15s
                %.2s
                """,  "-".repeat(60),sum , checkoutServer.subTotal(),discount, checkoutServer.discount(), vat , checkoutServer.vat(),  "=".repeat(60),
                billTotal, checkoutServer.billTotal(),"=".repeat(60));

        System.out.printf("""
                BILL TOTAL: %s
                AMOUNT PAID: %s
                BALANCE:     %s
                %s
                   THANKS FOR YOUR PATRONAGE
                 %s
                """ , checkoutServer.billTotal(), amountGiven , balance ,"=".repeat(60),"=".repeat(60));
    }
}


