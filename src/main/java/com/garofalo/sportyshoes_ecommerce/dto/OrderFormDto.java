package com.garofalo.sportyshoes_ecommerce.dto;

import java.util.List;

public class OrderFormDto {

    static private List<OrderProductDto> productOrders;

    static public List<OrderProductDto> getProductOrders() {
        return productOrders;
    }

    static public void setProductOrders(List<OrderProductDto> productOrders) {
        productOrders = productOrders;
    }



}
