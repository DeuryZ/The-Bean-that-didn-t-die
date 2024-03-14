package com.example.TBTDD.persistence.DTO;

public class OfficeDTO {

    private String officeCode;
    private String city;
    private String country;
    private String region;
    private String postalCode;
    private String phone;
    private String addressLine1;
    private String addressLine2;

    public OfficeDTO() {
    }

    @Override
    public String toString() {
        return "OfficeDTO{" +
                "officeCode='" + officeCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                '}';
    }
}
