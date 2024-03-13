package com.example.TBTDD.persistence.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "oficina")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_oficina")
    private Integer officeCode;

    @Column(name = "ciudad", length = 30)
    private String city;

    @Column(name = "pais", length = 50)
    private String country;

    @Column(name = "region", length = 50, nullable = true)
    private String region;

    @Column(name = "codigo_postal", length = 10)
    private String postalCode;

    @Column(name = "telefono", length = 20)
    private String phone;

    @Column(name = "linea_direccion1", length = 50)
    private String addressLine1;

    @Column(name = "linea_direccion2", length = 50, nullable = true)
    private String addressLine2;


    public Office() {
    }

    public Office(Integer officeCode, String city, String country, String region, String postalCode, String phone, String addressLine1, String addressLine2) {
        this.officeCode = officeCode;
        this.city = city;
        this.country = country;
        this.region = region;
        this.postalCode = postalCode;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }

    public Integer getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(Integer officeCode) {
        this.officeCode = officeCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
}
