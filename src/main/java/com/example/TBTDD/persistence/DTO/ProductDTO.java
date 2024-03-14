package com.example.TBTDD.persistence.DTO;

import java.math.BigDecimal;

public class ProductDTO {
    private String productCode;
    private String name;

    private String dimensions;
    private String supplier;
    private String description;
    private short quantityInStock;
    private BigDecimal salePrice;
    private BigDecimal supplierPrice;

    public ProductDTO() {
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

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", supplier='" + supplier + '\'' +
                ", description='" + description + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", salePrice=" + salePrice +
                ", supplierPrice=" + supplierPrice +
                '}';
    }
}
