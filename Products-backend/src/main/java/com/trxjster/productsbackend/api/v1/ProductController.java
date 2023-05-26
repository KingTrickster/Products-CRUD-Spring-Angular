package com.trxjster.productsbackend.api.v1;

import com.trxjster.productsbackend.model.Product;
import com.trxjster.productsbackend.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.Duration;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    Flux<Product> getAll(){
        return productService.getProducts();
    }

    @PostMapping("/products")
    Mono<Product> createProduct(@Valid @RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/products/{id}")
    public Mono<Product> getProductById(@PathVariable(value = "id") String productId) {
        return productService.getProduct(productId);
    }

    @PutMapping("/products/")
    public Mono<Product> updateProduct(@Valid @RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public Mono<Void> deleteProduct(@PathVariable(value = "id") String productId) {

        return productService.deleteProduct(productId);
    }

    // Products are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/products", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> streamAllProducts() {
        return productService.getProducts().delayElements(Duration.ofSeconds(1));
    }
}
