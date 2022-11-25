package com.example.delivery.client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("select new com.example.delivery.client.ClientResponseDto(c.id,c.fullName,c.cart,c.location.id) from Client  c")
    Page<ClientResponseDto> findAllClients(Pageable pageable);

    @Query("select new com.example.delivery.client.ClientResponseDto(c.id,c.fullName,c.cart," +
            "c.location.id) from Client c where c.id=:id")
    Optional<ClientResponseDto> findClientById(int id);
}
