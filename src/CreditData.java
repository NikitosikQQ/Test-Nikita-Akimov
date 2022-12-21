public class CreditData {
    private String[] creditInfo;
    private double[] creditValues;

    public void setCreditInfo(String scString) {
        creditInfo = scString.split(" ");
        creditValues = new double[creditInfo.length];
    }

    public void setCreditValues(int i) {
        creditValues[i] = Double.parseDouble(creditInfo[i]);
    }

    public int getCreditInfoLength() {
        return creditInfo.length;
    }

    public String getCreditInfo(int n) {
        return creditInfo[n];
    }

    public double getCreditValues(int i) {
        return creditValues[i];
    }

}
