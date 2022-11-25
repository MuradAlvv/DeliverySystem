package com.example.delivery.client;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public Page<ClientResponseDto> getPage(@RequestParam int page, @RequestParam int size) {
        return clientService.getPage(page, size);
    }

    @GetMapping("/{id}")
    public ClientResponseDto getById(@PathVariable int id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public void create(@RequestBody ClientRequestDto clientRequestDto) {
        clientService.create(clientRequestDto);
    }
}
