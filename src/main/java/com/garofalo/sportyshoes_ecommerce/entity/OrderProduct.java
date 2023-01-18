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
    private OrderProductPK pk;

    @Column(nullable = false)
    private Integer quantity;


    //CONSTRUCTORS
    public OrderProduct() {
    }

    public OrderProduct(OrderEntity order, ProductEntity product, Integer quantity) {
        pk = new OrderProductPK();
        pk.setOrderEntity(order);
        pk.setProductEntity(product);
        this.quantity = quantity;
    }

    //GETTERS & SETTERS
    public OrderProductPK getPk() {
        return pk;
    }

    public void setPk(OrderProductPK pk) {
        this.pk = pk;
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
        return this.pk.getProductEntity();
    }

    @Transient
    public Double getTotalPrice() {
        return getProductEntity().getPrice() * getQuantity();
    }

}
