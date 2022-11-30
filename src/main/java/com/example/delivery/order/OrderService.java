package com.example.delivery.order;

import com.example.delivery.client.Client;
import com.example.delivery.client.ClientRepository;
import com.example.delivery.order.delivery.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    private final DeliveryService deliveryService;

    public void makeOrder(int clientId){
        Order order = new Order();
        Client client = clientRepository.findById(clientId).orElseThrow();
        order.setAuthor(client);
        order.setCost(client.getCart().getCost());
        order.setStore(client.getCart().getProductList().get(0).getStore());
        order.setCost(client.getCart().getCost());
        orderRepository.save(order);
        deliveryService.beginDeliver(order);
        orderRepository.save(order);

    }
}
