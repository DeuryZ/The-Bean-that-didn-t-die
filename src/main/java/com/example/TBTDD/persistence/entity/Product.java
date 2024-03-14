package com.example.TBTDD.persistence.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "producto")
public class Product {
    @Id
    @Column (name="codigo_producto", length = 15, nullable = false)
    private String productCode;

    @Column(name="nombre" , length=70, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "gama", nullable = false)
    private RangeProduct rangeProduct;

    @Column (name="dimensiones", length = 25, nullable = true)
    private String dimensions;

    @Column (name= "proveedor", length = 50, nullable = true)
    private String supplier;

    @Lob
    @Column (name="descripcion", nullable = true, columnDefinition = "TEXT")
    private String description;

    @Column (name="cantidad_en_stock", length = 6, nullable = false)
    private short quantityInStock;

    @Column (name="precio_venta", precision= 15, scale= 2, nullable = false)
    private BigDecimal salePrice;

    @Column (name="precio_proveedor", precision=15, scale=2, nullable = true)
    private BigDecimal supplierPrice;

    public Product() {
    }

    public Product(String productCode, String name, RangeProduct rangeProduct, String dimensions, String supplier, String description, short quantityInStock, BigDecimal salePrice, BigDecimal supplierPrice) {
        this.productCode = productCode;
        this.name = name;
        this.rangeProduct = rangeProduct;
        this.dimensions = dimensions;
        this.supplier = supplier;
        this.description = description;
        this.quantityInStock = quantityInStock;
        this.salePrice = salePrice;
        this.supplierPrice = supplierPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RangeProduct getRangeProduct() {
        return rangeProduct;
    }

    public void setRangeProduct(RangeProduct rangeProduct) {
        this.rangeProduct = rangeProduct;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(BigDecimal supplierPrice) {
        this.supplierPrice = supplierPrice;
    }
}
