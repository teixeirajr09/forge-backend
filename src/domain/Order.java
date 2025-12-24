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

    public UUID getId() {
        return id;
    }

    public Priority getPriority() {
        return priority;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void startProcessing() {
        if (status != OrderStatus.CREATED) {
            throw new IllegalStateException(
                    "Order can only be processed from CREATED state"
            );
        }
        this.status = OrderStatus.PROCESSING;
    }

    public void complete() {
        if (status != OrderStatus.PROCESSING) {
            throw new IllegalStateException(
                    "Order can only be completed from PROCESSING state"
            );
        }
        this.status = OrderStatus.COMPLETED;
    }

    public void cancel() {
        if (status == OrderStatus.COMPLETED ||  status == OrderStatus.CANCELED) {
            throw new IllegalStateException(
                    "Order cannot be canceled from " + status + " state"
            );
        }
        this.status = OrderStatus.CANCELED;
    }
}
