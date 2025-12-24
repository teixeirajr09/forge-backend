package domain;

import java.util.UUID;

public class Order {
    private final UUID id;
    private final Priority priority;
    private OrderStatus status;


    public Order(Priority priority) {
        this.id = UUID.randomUUID();
        this.priority = priority;
        this.status = OrderStatus.CREATED;
    }

    public UUID getID() {
        return id;
    }

    public Priority getPriority() {
        return priority;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
