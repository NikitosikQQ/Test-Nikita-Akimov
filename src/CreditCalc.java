import java.util.Scanner;

public class CreditCalc {

    int years;

    public int getVerification(CreditData CreditData) throws CreditException {
        if (CreditData.getCredit() > 0 && CreditData.getPayment() > 0 && CreditData.getPercent() > 0) {
            if (CreditData.getClientType().equalsIgnoreCase("business")) {
                boolean possibility = ((CreditData.getCredit() - (CreditData.getPayment() * 12)) + (CreditData.getCredit() / 100 * CreditData.getPercent()) - (CreditData.getPayment() * 12) < CreditData.getCredit());
                if (possibility) {
                    return 1;
                } else throw new CreditException("Введены невозможные значения по кредиту!");
            } else if (CreditData.getCredit() + (CreditData.getCredit() / 100 * CreditData.getPercent()) - (CreditData.getPayment() * 12) < CreditData.getCredit()) {
                return 1;
            } else throw new CreditException("Введены невозможные значения по кредиту!");
        } else throw new CreditException("Введены невозможные значения по кредиту!");
    }

    public void getOverpayment(CreditData CreditData) {
        double credit = CreditData.getCredit();
        String client = CreditData.getClientType();
        double payment = CreditData.getPayment();
        double percent = CreditData.getPercent();
        double sum = 0;
        double balance = 0;

        if (client.equalsIgnoreCase("business")) {
            balance = credit;
            credit = balance - (payment * 12);
        } else {
            balance = credit + (credit / 100 * percent);
            sum = sum + credit * (percent / 100);
            credit = balance - (payment * 12);
        }

        while (credit > 0) {
            balance = credit + (credit / 100 * percent);
            sum = sum + credit * (percent / 100);
            credit = balance - (payment * 12);
        }
        System.out.println("Сумма переплаты по кредиту = " + sum);
    }
}
