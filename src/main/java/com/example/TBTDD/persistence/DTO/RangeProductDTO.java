package com.example.TBTDD.persistence.DTO;

import com.example.TBTDD.persistence.entity.RangeProduct;

public class RangeProductDTO {
    private String range;
    private String textDescription;
    private String htmlDescription;
    private String image;

    public RangeProductDTO() {
    }


    public RangeProductDTO(String range, String textDescription, String htmlDescription, String image) {
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

    @Override
    public String toString() {
        return "RangeProductDTO{" +
                "range='" + range + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public static RangeProductDTO toDTO(RangeProduct rangeProduct) {
        RangeProductDTO rangeProductDTO = new RangeProductDTO();
        rangeProductDTO.setRange(rangeProduct.getRange());
        rangeProductDTO.setTextDescription(rangeProduct.getTextDescription());
        rangeProductDTO.setHtmlDescription(rangeProduct.getHtmlDescription());
        rangeProductDTO.setImage(rangeProduct.getImage());
        return rangeProductDTO;
    }

    public static RangeProduct toEntity(RangeProductDTO rangeProductDTO) {
        RangeProduct rangeProduct = new RangeProduct();
        rangeProduct.setRange(rangeProductDTO.getRange());
        rangeProduct.setTextDescription(rangeProductDTO.getTextDescription());
        rangeProduct.setHtmlDescription(rangeProductDTO.getHtmlDescription());
        rangeProduct.setImage(rangeProductDTO.getImage());
        return rangeProduct;
    }
}
