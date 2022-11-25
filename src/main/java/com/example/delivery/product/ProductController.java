package com.example.delivery.product;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductResponseDto> getPage(@RequestParam int page, @RequestParam int size) {
        return productService.getPage(page, size);
    }

    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable int id){
        return productService.getProductById(id);
    }
}
