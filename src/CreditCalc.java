import java.util.Scanner;

public class CreditCalc {

    int Years;

//    public void setCredit(double credit){
//
//    }
//
//    public void setPayment(double payment) {
//
//    }
//
//    public void setPercent(double percent) {
//
//    }
//
//    public void setClient(String client) {
//        this.client = client;
//    }

    public void getOverpayment(double credit, double payment, double percent, String client) {

        Years = (int)Math.ceil((credit*(percent/100+1))/payment/12);
        //System.out.println("количество циклов годов = "+ Years);
        double sum = 0;
        double ostatok;

        for (int i=0; i<Years; i++){
            if((client.equalsIgnoreCase("business")) && (i == 0)){
                ostatok = credit;
                sum = 0;
            }else {
                ostatok = credit+(credit/100*percent);
                    sum = sum + credit*(percent/100);}
            credit = ostatok - (payment*12);
        }
System.out.println("Сумма переплаты по кредиту = "+ sum);
    }
}
