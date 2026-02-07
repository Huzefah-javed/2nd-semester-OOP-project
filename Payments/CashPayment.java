package Payments;

public class CashPayment implements Payment {

    public boolean pay(double amount) {
        System.out.println("Paid Rs." + amount + " in Cash.");
        return true;
    }
}
