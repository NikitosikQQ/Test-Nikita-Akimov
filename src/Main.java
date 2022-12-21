import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NewExceptions {
        final String HUMAN_TYPE = "human";
        final String BUSINESS_TYPE = "business";

        CreditData data = new CreditData();
        CreditCalc calc = new CreditCalc();

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные по кредиту через пробел:");
        data.setCreditInfo(sc.nextLine());


        if (data.getCreditInfoLength() == 4) {
            try {
                boolean checkHum = HUMAN_TYPE.equalsIgnoreCase(data.getCreditInfo(3));
                boolean checkBus = BUSINESS_TYPE.equalsIgnoreCase(data.getCreditInfo(3));
                if (checkHum || checkBus) {
                    for (int i = 0; i < data.getCreditInfoLength() - 1; i++) {
                        data.setCreditValues(i);
                    }
                    if (calc.getVerification(data.getCreditValues(0), data.getCreditValues(1), data.getCreditValues(2), data.getCreditInfo(3)) == 1) {
                        calc.getOverpayment(data.getCreditValues(0), data.getCreditValues(1), data.getCreditValues(2), data.getCreditInfo(3));
                    }
                } else throw new NewExceptions("Введен некорректный тип клиента!");
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException t) {
                t.printStackTrace();
            }
        } else throw new NewExceptions("Введено неверное количество параметров!");
    }
}


