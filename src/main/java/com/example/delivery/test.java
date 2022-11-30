package com.example.delivery;

import com.example.delivery.address.Address;
import com.example.delivery.address.AddressRepository;
import com.example.delivery.city.City;
import com.example.delivery.city.CityRepository;
import com.example.delivery.client.Client;
import com.example.delivery.client.ClientRepository;
import com.example.delivery.client.ClientService;
import com.example.delivery.client.cart.Cart;
import com.example.delivery.courier.Courier;
import com.example.delivery.courier.CourierRepository;
import com.example.delivery.courier.TransportType;
import com.example.delivery.order.delivery.DeliveryService;
import com.example.delivery.order.OrderService;
import com.example.delivery.product.Product;
import com.example.delivery.product.ProductRepository;
import com.example.delivery.product.ProductType;
import com.example.delivery.store.Store;
import com.example.delivery.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class test {

    private final CityRepository cityRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;
    private final StoreRepository storeRepository;
    private final ClientRepository clientRepository;

    private final ClientService clientService;

    private final OrderService orderService;
    private final CourierRepository courierRepository;
    private final DeliveryService deliveryService;


    @PostConstruct
    public void init() throws InterruptedException {
        City city = new City();
        city.setName("28 may");
        cityRepository.save(city);

        City city1 = new City();
        city1.setName("Narimanov");
        cityRepository.save(city1);

        Address address = new Address();
        address.setCity(city1);
        address.setApartment("45");
        address.setStreet("abc street");
        addressRepository.save(address);

        Address address1 = new Address();
        address1.setCity(city1);
        address1.setApartment("9");
        address1.setStreet("abdc street");
        addressRepository.save(address1);

        Store store = new Store();
        store.setName("Araz");
        store.setAddress(address);
        storeRepository.save(store);

        Product product = new Product();
        product.setProductType(ProductType.DAIRY);
        product.setTitle("Milk");
        product.setPrice("12");
        product.setStore(store);
        productRepository.save(product);

        Product product1 = new Product();
        product1.setProductType(ProductType.DAIRY);
        product1.setTitle("Cheeze");
        product1.setPrice("6");
        product1.setStore(store);
        productRepository.save(product1);

        Cart cart = new Cart();

        Client client = new Client();
        client.setFullName("Mike");
        client.setCart(cart);
        client.setLocation(address1);
        clientRepository.save(client);
        clientService.addToCart(1, 1);
        clientService.addToCart(1, 2);

        Courier courier = new Courier();
        courier.setLocation(address);
        courier.setFullName("John");
        courier.setTransportType(TransportType.BIKE);
        courierRepository.save(courier);


//        orderService.makeOrder(1);
//        Thread.sleep(10000);
//        deliveryService.endDelivery(courier);


        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        addressList.add(address1);

    }

}
