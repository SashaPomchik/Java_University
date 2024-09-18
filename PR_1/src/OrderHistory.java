import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderHistory {
    private List<Order> orders;

    public OrderHistory() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        return "Історія замовлень{"  +
                orders +
                '}';
    }
}
