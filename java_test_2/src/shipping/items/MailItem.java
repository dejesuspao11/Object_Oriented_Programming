package shipping.items;

import java.time.LocalDateTime;
import enums.DistributionPoints;
import senders.recipients.User;

public class MailItem extends Package {
    private double weight; // in kilograms
    private String contentDescription;

    public MailItem(User sender, User recipient, double weight, String contentDescription) {
        super(sender, recipient);
        this.weight = weight;
        this.contentDescription = contentDescription;
    }

    @Override
    public LocalDateTime getEstimateArrival() {
        // Example: Estimate arrival based on weight and destination
        double arrivalTimeHours = DistributionPoints.QuintanaRoo.getArrivalTimeHours(); // Example using Quintana Roo destination
        return LocalDateTime.now().plusHours((long) arrivalTimeHours);
    }

    @Override
    public double estimatePrice() {
        // Example: Cost calculation based on weight and destination
        double costPerKg = DistributionPoints.QuintanaRoo.getCostPerKgUSD(); // Example using Quintana Roo destination
        return weight * costPerKg;
    }

    // Getters and setters for weight and contentDescription
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }
}