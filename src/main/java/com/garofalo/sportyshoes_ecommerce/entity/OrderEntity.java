package com.garofalo.sportyshoes_ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "order_entity")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="orderProducts")
public class OrderEntity {

    //PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, name = "orderId")
    private Long orderId;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate orderDateCreated;

    @Column
    private String orderStatus;

    @JsonManagedReference
    @OneToMany(mappedBy = "orderProductPK.orderEntity")
    private List<OrderProduct> orderProducts = new ArrayList<>();


    //CONSTRUCTORS
    public OrderEntity() {
    }

    public OrderEntity(LocalDate orderDateCreated, String orderStatus, List<OrderProduct> orderProducts) {
        this.orderDateCreated = orderDateCreated;
        this.orderStatus = orderStatus;
        this.orderProducts = orderProducts;
    }

    public OrderEntity(Long orderId, LocalDate dateCreated, String status, List<OrderProduct> orderProducts) {
        this.orderId = orderId;
        this.orderDateCreated = dateCreated;
        this.orderStatus = status;
        this.orderProducts = orderProducts;
    }

    //GETTERS & SETTERS
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDateCreated() {
        return orderDateCreated;
    }

    public void setOrderDateCreated(LocalDate dateCreated) {
        this.orderDateCreated = dateCreated;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String status) {
        this.orderStatus = status;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    //CUSTOM METHODS
    @Transient
    public double getTotalOrderPrice(){
        double sum = 0D;
        List<OrderProduct> orderProducts = getOrderProducts();
        for (OrderProduct orderProduct : orderProducts){
            sum += orderProduct.getTotalPrice();
        }
        return sum;
    }

    @Transient
    public int getNumberOfProducts(){
        return this.orderProducts.size();
    }



}
