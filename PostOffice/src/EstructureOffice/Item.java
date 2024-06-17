package EstructureOffice;

public class Item extends Package {
    private double weight;
    private String description;

    public Item(User sender, User recipient, double weight, String description) {
        super(sender, recipient);
        this.weight = weight;
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public double estimatePrice(Distribution destination) {
        return weight * destination.getCostPerKg();
    }
}
