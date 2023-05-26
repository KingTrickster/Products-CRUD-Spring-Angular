package com.trxjster.productsbackend.service;

import com.trxjster.productsbackend.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> getProducts();
    Mono<Product> getProduct(String productId);
    Mono<Product> createProduct(Product product);
    Mono<Product> updateProduct(Product product);
    Mono<Void> deleteProduct(String id);
}
