import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные по кредиту в следующем порядке:Сумма денег в кредите," +
                " ежемес.платеж, процентная ставка, тип клиента через пробел");
        String scString = sc.nextLine();
        String[] scStrings = scString.split(" ");
        double[] scNumbers = new double[scStrings.length];
        String Hu = "human";
        String Bu = "business";
        boolean checkHu = Hu.equalsIgnoreCase(scStrings[3]);
        boolean checkBu = Bu.equalsIgnoreCase(scStrings[3]);
//        System.out.println(checkBu);
//        System.out.println(checkHu);

        CreditCalc calc = new CreditCalc();

        if (scStrings.length == 4) {
            if(checkHu==true || checkBu==true) {
                try {
                    for (int i = 0; i < scStrings.length - 1; i++) {
                        scNumbers[i] = Double.parseDouble(scStrings[i]);
                    }
                    if (Main.condition(scNumbers[0], scNumbers[1], scNumbers[2], scStrings[3]) == 1){
                        calc.getOverpayment(scNumbers[0], scNumbers[1], scNumbers[2], scStrings[3]);
                    }else System.out.println("Введены невозможные значения по кредиту!");
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException t) {
                    System.out.println("Значения введены некорректно!");
                }
            }else System.out.println("Некорректно введен тип клиента!");
        } else System.out.println("Введено больше или меньше значений для расчета! ");
    }
    public static int condition (double i0, double i1, double i2, String i3) {
        if (i0 > 0 && i1 > 0 && i2 > 0 && i0 > i1 && i1 > i2) {
            if (i3.equalsIgnoreCase("business")){
             boolean C = ((i0-(i1*12))+(i0/100*i2)-(i1*12) < i0);
             if (C) return 1;else return 0;
            } else
             if(i0+(i0/100*i2)-(i1*12) < i0) return 1; else return 0;

        } else return 0;
    }

}

