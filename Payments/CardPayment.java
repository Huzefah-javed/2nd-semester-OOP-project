package Payments;

public class CardPayment implements Payment {

    public boolean pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Card.");
        return true;
    }
}
