package com.example.TBTDD.persistence.entity.orderdetail;


import com.example.TBTDD.persistence.entity.Order;
import com.example.TBTDD.persistence.entity.Product;
import jakarta.persistence.*;

@Entity
@Table (name = "detalle_pedido")
public class OrderDetail {

@EmbeddedId
    private OrderDetailId id;

@ManyToOne
@MapsId("orderCode")
@JoinColumn(name = "codigo_pedido")
private Order order;

@ManyToOne
@MapsId ("productCode")
@JoinColumn(name = "codigo_producto")
private Product product;

@Column(name = "cantidad", length = 11)
private int amount;

@Column (name ="precio_unidad", precision= 15 ,scale =2)
private float unitPrice;

@Column (name = "numero_linea", length = 6)
private short lineNumber;

    public OrderDetail(OrderDetailId id, Order order, Product product, int amount, float unitPrice, short lineNumber) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.lineNumber = lineNumber;
    }

    public OrderDetailId getId() {
        return id;
    }

    public void setId(OrderDetailId id) {
        this.id = id;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public short getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(short lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", amount=" + amount +
                ", unitPrice=" + unitPrice +
                ", lineNumber=" + lineNumber +
                '}';
    }
}
