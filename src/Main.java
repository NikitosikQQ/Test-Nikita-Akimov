import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CreditException {
        final String HUMAN_TYPE = "human";
        final String BUSINESS_TYPE = "business";

        CreditData data = new CreditData();
        CreditCalc calc = new CreditCalc();

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные по кредиту через пробел:");
        String scString = sc.nextLine();
        String creditInfo[] = scString.split(" ");
        data.setCreditInfo(creditInfo);


        if (data.getCreditInfoLength(creditInfo) == 4) {
           creditInfo = null;
            try {
                boolean checkHum = HUMAN_TYPE.equalsIgnoreCase(data.getClientType());
                boolean checkBus = BUSINESS_TYPE.equalsIgnoreCase(data.getClientType());
                if (checkHum || checkBus) {
                    if (calc.getVerification(data) == 1) {
                        calc.getOverpayment(data);
                    }
                } else throw new CreditException("Введен некорректный тип клиента!");
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException t) {
                t.printStackTrace();
            }
        } else throw new CreditException("Введено неверное количество параметров!");
    }
}


