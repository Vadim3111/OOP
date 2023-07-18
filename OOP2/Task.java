import java.util.LinkedList;
import java.util.Queue;

interface QueueBehaviour<T> {
    void enqueue(T element);
    T dequeue();
    T first();
    boolean isEmpty();
    int size();
}

interface MarketBehaviour {
    void takeOrder(String order);
    String serveNextOrder();
}

class Market implements QueueBehaviour<String>, MarketBehaviour {
    private Queue<String> orders;

    public Market() {
        orders = new LinkedList<>();
    }

    // Методы из QueueBehaviour
    @Override
    public void enqueue(String element) {
        orders.add(element);
    }

    @Override
    public String dequeue() {
        return orders.poll();
    }

    @Override
    public String first() {
        return orders.peek();
    }

    @Override
    public boolean isEmpty() {
        return orders.isEmpty();
    }

    @Override
    public int size() {
        return orders.size();
    }

    // Методы из MarketBehaviour
    @Override
    public void takeOrder(String order) {
        enqueue(order);
    }

    @Override
    public String serveNextOrder() {
        if (isEmpty()) {
            return "Нет заказов в очереди.";
        } else {
            return dequeue();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        market.takeOrder("Пицца");
        market.takeOrder("Суши");
        market.takeOrder("Бургер");

        System.out.println("Количество заказов в очереди: " + market.size());

        System.out.println("Обслуживаем заказы:");
        while (!market.isEmpty()) {
            System.out.println("Обслуживаем заказ: " + market.serveNextOrder());
        }

        System.out.println("Количество заказов в очереди: " + market.size());
    }
}