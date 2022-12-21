import java.util.Scanner;

public class CreditCalc {

    int years;

    public int getVerification(double credit, double payment, double percent, String client) throws NewExceptions {
        if (credit > 0 && payment > 0 && percent > 0 && credit > payment && payment > percent) {
            if (client.equalsIgnoreCase("business")) {
                boolean possibility = ((credit - (payment * 12)) + (credit / 100 * percent) - (payment * 12) < credit);
                if (possibility) {
                    return 1;
                } else throw new NewExceptions("Введены невозможные значения по кредиту!");
            } else if (credit + (credit / 100 * percent) - (payment * 12) < credit) {
                return 1;
            } else throw new NewExceptions("Введены невозможные значения по кредиту!");
        } else throw new NewExceptions("Введены невозможные значения по кредиту!");
    }

    public void getOverpayment(double credit, double payment, double percent, String client) {

        double sum = 0;
        double balance = 0;

        while (credit > 0) {
            if ((client.equalsIgnoreCase("business")) && (balance == 0)) {
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
