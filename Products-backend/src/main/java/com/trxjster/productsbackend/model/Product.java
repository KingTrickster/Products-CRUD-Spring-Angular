package com.trxjster.productsbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Product")
@Data @AllArgsConstructor
public class Product {

    @Id
    private String id;
    private String productName;
    private Integer price;
    private String productDesc;

}
