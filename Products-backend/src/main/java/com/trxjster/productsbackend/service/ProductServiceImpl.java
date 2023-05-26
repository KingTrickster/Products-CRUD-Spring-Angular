package com.trxjster.productsbackend.service;

import com.trxjster.productsbackend.model.Product;
import com.trxjster.productsbackend.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> getProduct(String productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Mono<Product> createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> updateProduct(Product product) {
        return productRepository.findById(product.getId()).flatMap(existingProduct -> {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setProductDesc(product.getProductDesc());
            return productRepository.save(existingProduct);
        });
    }

    @Override
    public Mono<Void> deleteProduct(String productId) {
        return productRepository.deleteById(productId);
    }
}
