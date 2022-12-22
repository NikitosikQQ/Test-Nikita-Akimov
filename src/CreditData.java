public class CreditData {
    private String[] creditInfo;
    private double[] creditValues;
    private double credit;
    private double percent;
    private double payment;
    private String clientType;

    public void setCreditInfo(String scString) {
        creditInfo = scString.split(" ");
        creditValues = new double[creditInfo.length];
        clientType = creditInfo[3];
    }

    public void setCreditValues(int i) {
        creditValues[i] = Double.parseDouble(creditInfo[i]);
        credit = creditValues[0];
        payment = creditValues[1];
        percent = creditValues[2];
    }

    public int getCreditInfoLength() {
        return creditInfo.length;
    }

    public String getCreditInfo(int n) {
        return creditInfo[n];
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
