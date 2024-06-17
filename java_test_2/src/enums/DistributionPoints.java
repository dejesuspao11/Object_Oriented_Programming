package enums;

public enum DistributionPoints {
    Oaxaca("OAX", 48.2, 2.50),
    QuintanaRoo("QROO", 36.5, 3.70),
    Morelos("MOR", 18.4, 1.60),
    Queretaro("QRO", 35.3, 3.0),
    Sinaloa("SIN", 48.4, 4.0);

    private String code;
    private double arrivalTimeHours;
    private double costPerKgUSD;

    // Constructor
    DistributionPoints(String code, double arrivalTimeHours, double costPerKgUSD) {
        this.code = code;
        this.arrivalTimeHours = arrivalTimeHours;
        this.costPerKgUSD = costPerKgUSD;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public double getArrivalTimeHours() {
        return arrivalTimeHours;
    }

    public double getCostPerKgUSD() {
        return costPerKgUSD;
    }
}
