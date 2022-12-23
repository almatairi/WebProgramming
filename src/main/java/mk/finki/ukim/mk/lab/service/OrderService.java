package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Order;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order placeOrders(String balloonColor, String clientName, String address);
    List<Order> findAll();

    Optional<Order> findById(Long id);

    Optional<Order> save(String balloonColor, String balloonSize, String clientName, String clientAddress);
    Order addPendingOrder(String balloonColor, String balloonSize, String clientName, String clientAddress);

    Order getPendingOrder();
    void removePendingOrder();

}
