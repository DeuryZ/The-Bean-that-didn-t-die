package com.example.TBTDD.persistence.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "gama_producto")
public class RangeProduct {
    @Id
    @Column(name = "gama", length = 50, nullable = false)
    private String range;

    @Lob
    @Column (name="descripcion_texto", nullable = true, columnDefinition = "TEXT")
    private String textDescription;

    @Lob
    @Column (name="descripcion_html", nullable = true, columnDefinition = "TEXT")
    private String htmlDescription;

    @Column (name="imagen", length = 256)
    private String image;

    @OneToMany(mappedBy = "rangeProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();


    public RangeProduct() {

    }

    public RangeProduct(String range, String textDescription, String htmlDescription, String image) {
        this.range = range;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
        this.image = image;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}