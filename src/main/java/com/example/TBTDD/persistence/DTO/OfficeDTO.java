package com.example.TBTDD.persistence.DTO;

import com.example.TBTDD.persistence.entity.Office;

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

    public OfficeDTO(String officeCode, String city, String country, String region, String postalCode, String phone, String addressLine1, String addressLine2) {
        this.officeCode = officeCode;
        this.city = city;
        this.country = country;
        this.region = region;
        this.postalCode = postalCode;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
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
    public static OfficeDTO toDTO(Office office) {
        OfficeDTO officeDTO = new OfficeDTO();
        officeDTO.setOfficeCode(office.getOfficeCode());
        officeDTO.setCity(office.getCity());
        officeDTO.setCountry(office.getCountry());
        officeDTO.setRegion(office.getRegion());
        officeDTO.setPostalCode(office.getPostalCode());
        officeDTO.setPhone(office.getPhone());
        officeDTO.setAddressLine1(office.getAddressLine1());
        officeDTO.setAddressLine2(office.getAddressLine2());
        return officeDTO;
    }

    public static Office toEntity(OfficeDTO officeDTO) {
        Office office = new Office();
        office.setOfficeCode(officeDTO.getOfficeCode());
        office.setCity(officeDTO.getCity());
        office.setCountry(officeDTO.getCountry());
        office.setRegion(officeDTO.getRegion());
        office.setPostalCode(officeDTO.getPostalCode());
        office.setPhone(officeDTO.getPhone());
        office.setAddressLine1(officeDTO.getAddressLine1());
        office.setAddressLine2(officeDTO.getAddressLine2());
        return office;
    }
}
