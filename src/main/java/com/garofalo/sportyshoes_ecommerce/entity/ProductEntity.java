package com.garofalo.sportyshoes_ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class ProductEntity {


    //PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, name = "id")
    private Long productId;

    @Column
    private String productName;

    @Column
    private Double productPrice;

    @Column
    private String productDescription;


    //CONSTRUCTORS
    public ProductEntity() {
    }


    public ProductEntity(Long productId, String productName, Double productPrice, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    //GETTERS & SETTERS


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
