package com.example.delivery.client;

import com.example.delivery.client.cart.Cart;
import com.example.delivery.product.Product;
import com.example.delivery.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.generic.InstructionConstants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final ClientMapper clientMapper;

    public void addToCart(int clientId, int productId) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        Cart cart = client.getCart();
        cart.add(product);
        cart.setCost(cart.getTotalCost() + "");
        client.setCart(cart);
        clientRepository.save(client);
    }

    public Page<ClientResponseDto> getPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return clientRepository.findAllClients(pageable);
    }

    public ClientResponseDto getClientById(int id) {
        return clientRepository.findClientById(id).orElseThrow();
    }

    public void create(ClientRequestDto clientRequestDto) {
        Client client = clientMapper.toEntity(clientRequestDto);
        clientRepository.save(client);
    }

}
