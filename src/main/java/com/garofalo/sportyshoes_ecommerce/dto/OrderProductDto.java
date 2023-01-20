package com.garofalo.sportyshoes_ecommerce.dto;

import com.garofalo.sportyshoes_ecommerce.entity.ProductEntity;

public class OrderProductDto {

    private ProductEntity productEntity;
    private Integer quantity;


    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
