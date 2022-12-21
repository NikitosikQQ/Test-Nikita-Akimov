import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные по кредиту через пробел:");
        String scString = sc.nextLine();
        String[] creditInfo = scString.split(" ");
        double[] creditValues = new double[creditInfo.length];

        String Hum = "human";
        String Bus = "business";

        CreditCalc calc = new CreditCalc();

        if (creditInfo.length == 4) {
            try {
                boolean checkHum = Hum.equalsIgnoreCase(creditInfo[3]);
                boolean checkBus = Bus.equalsIgnoreCase(creditInfo[3]);
                if (checkHum || checkBus) {
                    for (int i = 0; i < creditInfo.length - 1; i++) {
                        creditValues[i] = Double.parseDouble(creditInfo[i]);
                    }
                    if (calc.getVerification(creditValues[0], creditValues[1], creditValues[2], creditInfo[3]) == 1) {
                        calc.getOverpayment(creditValues[0], creditValues[1], creditValues[2], creditInfo[3]);
                    } else System.out.println("Введены невозможные значения по кредиту!");
                } else System.out.println("Некорректно введен тип клиента!");
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException t) {
                System.out.println("Значения введены некорректно!");
            }

        } else System.out.println("Введено больше или меньше значений для расчета! ");
    }
}


