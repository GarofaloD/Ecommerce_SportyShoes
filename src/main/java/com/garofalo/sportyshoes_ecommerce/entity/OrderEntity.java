package com.garofalo.sportyshoes_ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    //PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, name = "orderId")
    private Long orderId;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

    @Column
    private String status;

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.order")
    private List<OrderProduct> orderProducts = new ArrayList<>();


    //CONSTRUCTORS
    public OrderEntity() {
    }

    public OrderEntity(Long orderId, LocalDate dateCreated, String status, List<OrderProduct> orderProducts) {
        this.orderId = orderId;
        this.dateCreated = dateCreated;
        this.status = status;
        this.orderProducts = orderProducts;
    }

    //GETTERS & SETTERS
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        List<OrderProduct> orderproducts = getOrderProducts();
        for (OrderProduct orderProduct : orderproducts){
            sum += orderProduct.getTotalPrice();
        }
        return sum;
    }

    @Transient
    public int getNumberOfProducts(){
        return this.orderProducts.size();
    }



}
