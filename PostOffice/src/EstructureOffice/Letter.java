package EstructureOffice;

public class Letter extends Package {
    private static final double BASE_COST = 1.0;

    public Letter(User sender, User recipient) {
        super(sender, recipient);
    }

    @Override
    public double estimatePrice(Distribution destination) {
        return BASE_COST;
    }
}
