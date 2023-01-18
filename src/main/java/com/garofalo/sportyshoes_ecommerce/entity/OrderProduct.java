package com.garofalo.sportyshoes_ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class OrderProduct {

    //PROPERTIES
    @EmbeddedId
    @JsonIgnore
    private OrderProductPK orderProductPK;

    @Column(nullable = false)
    private Integer quantity;


    //CONSTRUCTORS
    public OrderProduct() {
    }

    public OrderProduct(OrderEntity orderEntity, ProductEntity productEntity, Integer quantity) {
        orderProductPK = new OrderProductPK();
        orderProductPK.setOrderEntity(orderEntity);
        orderProductPK.setProductEntity(productEntity);
        this.quantity = quantity;
    }

    //GETTERS & SETTERS
    public OrderProductPK getOrderProductPK() {
        return orderProductPK;
    }

    public void setOrderProductPK(OrderProductPK pk) {
        this.orderProductPK = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    //CUSTOM METHODS
    @Transient
    public ProductEntity getProductEntity() {
        return this.orderProductPK.getProductEntity();
    }

    @Transient
    public Double getTotalPrice() {
        return getProductEntity().getProductPrice() * getQuantity();
    }

}
