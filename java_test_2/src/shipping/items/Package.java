package shipping.items;

import java.time.LocalDateTime;

import senders.recipients.User;

public abstract class Package {
    private User sender;
    private User recipient;

    public Package(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    // Abstract methods to be implemented by subclasses
    public abstract LocalDateTime getEstimateArrival();

    public abstract double estimatePrice();

    // Getters for sender and recipient
    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }
}
