package shipping.items;

import java.time.LocalDateTime;
import enums.DistributionPoints;
import senders.recipients.User;

public class Letter extends Package {

    public Letter(User sender, User recipient) {
        super(sender, recipient);
    }

    @Override
    public LocalDateTime getEstimateArrival() {
        // Example: Estimate 2 days for letter delivery
        return LocalDateTime.now().plusDays(2);
    }

    @Override
    public double estimatePrice() {
        // Example: Cost for sending a letter (assuming 1kg package cost)
        return DistributionPoints.Morelos.getCostPerKgUSD();
    }
}