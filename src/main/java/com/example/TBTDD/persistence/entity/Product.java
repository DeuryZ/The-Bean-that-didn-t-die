package com.example.TBTDD.persistence.entity;


import jakarta.persistence.*;

@Entity
@Table (name = "producto")
public class Product {
@Id
@Column (name="codigo_producto", length = 15)
@GeneratedValue (strategy = GenerationType.IDENTITY)
private String productCode;

@Column(name="nombre" , length=70)
private String name;
@Column (name ="gama", length =50)
private String range;
@Column (name="dimensiones", length = 25, nullable = true)
private String dimensions;
@Column (name= "proveedor", length = 50, nullable = true)
private String supplier;
@Column (name="descripcion", nullable = true)
private String description;
@Column (name="cantidad_en_stock", length = 6)
private short quantityInStock;
@Column (name="precio_venta", precision= 15, scale= 2)
private  double salePrice;
@Column (name="precio_proveedor", precision=15, scale=2, nullable = true)
private double supplierPrice;

    public Product(String productCode, String name, String range, String dimensions, String supplier, String description, short quantityInStock, double salePrice, double supplierPrice) {
        this.productCode = productCode;
        this.name = name;
        this.range = range;
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

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
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

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }
}
