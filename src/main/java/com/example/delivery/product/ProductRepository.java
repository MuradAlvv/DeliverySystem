package com.example.delivery.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select new com.example.delivery.product.ProductResponseDto(p.id,p.title,p.description, " +
            " p.price,p.expirationDate ,p.store,p.productType) from Product p")
    Page<ProductResponseDto> getAllProducts(Pageable pageable);


    @Query("select new com.example.delivery.product.ProductResponseDto(p.id,p.title,p.description, " +
            " p.price,p.expirationDate,p.store,p.productType ) from Product p where p.id=:id")
    Optional<ProductResponseDto> getProductById(int id);
}
