public class CreditData {
    private double credit;
    private double percent;
    private double payment;
    private String clientType;

    public void setCreditInfo(String scString[]) {

        credit = Double.parseDouble(scString[0]);
        payment = Double.parseDouble(scString[1]);
        percent = Double.parseDouble(scString[2]);
        clientType = scString[3];
    }

    public int getCreditInfoLength(String scString[]) {
        return scString.length;
    }

    public double getCredit() {
        return credit;
    }

    public double getPayment() {
        return payment;
    }

    public double getPercent() {
        return percent;
    }

    public String getClientType() {
        return clientType;
    }
}
