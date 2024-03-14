package com.example.TBTDD.persistence.embeddable;

import com.example.TBTDD.persistence.entity.Order;
import com.example.TBTDD.persistence.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class OrderDetailId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "codigo_pedido", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "codigo_producto", nullable = false)
    private Product product;

    public OrderDetailId() {
    }

    public OrderDetailId(Order orderId, Product productId) {
        this.order = orderId;
        this.product = productId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}