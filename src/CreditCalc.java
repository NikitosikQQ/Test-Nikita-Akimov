import java.util.Scanner;

public class CreditCalc {

    int years;

    public static int getVerification(double credit, double payment, double percent, String client) {
        if (credit > 0 && payment > 0 && percent > 0 && credit > payment && payment > percent) {
            if (client.equalsIgnoreCase("business")) {
                boolean possibility = ((credit - (payment * 12)) + (credit / 100 * percent) - (payment * 12) < credit);
                if (possibility) {
                    return 1;
                } else return 0;
            } else if (credit + (credit / 100 * percent) - (payment * 12) < credit) {
                return 1;
            } else return 0;
        } else return 0;
    }

    public void getOverpayment(double credit, double payment, double percent, String client) {

        years = (int) Math.ceil((credit * (percent / 100 + 1)) / payment / 12);
        double sum = 0;
        double balance;

        for (int i = 0; i < years; i++) {
            if ((client.equalsIgnoreCase("business")) && (i == 0)) {
                balance = credit;
                sum = 0;
            } else {
                balance = credit + (credit / 100 * percent);
                sum = sum + credit * (percent / 100);
            }
            credit = balance - (payment * 12);
        }
        System.out.println("Сумма переплаты по кредиту = " + sum);
    }
}
