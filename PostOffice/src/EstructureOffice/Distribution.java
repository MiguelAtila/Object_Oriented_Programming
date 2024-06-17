package EstructureOffice;

public enum Distribution {
    OAX("OAX", 48.2, 2.50),
    QROO("QROO", 36.5, 3.70),
    MOR("MOR", 18.4, 1.60),
    QRO("QRO", 35.3, 3.0),
    SIN("SIN", 48.4, 4.0);

    private String alias;
    private double arrivalTime;
    private double costPerKg;

    Distribution(String alias, double arrivalTime, double costPerKg) {
        this.alias = alias;
        this.arrivalTime = arrivalTime;
        this.costPerKg = costPerKg;
    }

    public String getAlias() {
        return alias;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public double getCostPerKg() {
        return costPerKg;
    }

    // Método estático para obtener una instancia de Distribution desde un alias
    public static Distribution fromAlias(String alias) {
        for (Distribution dist : values()) {
            if (dist.getAlias().equalsIgnoreCase(alias)) {
                return dist;
            }
        }
        throw new IllegalArgumentException("No enum constant for alias: " + alias);
    }
}

