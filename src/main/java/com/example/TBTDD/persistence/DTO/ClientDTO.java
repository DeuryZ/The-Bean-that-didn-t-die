package com.example.TBTDD.persistence.DTO;

import com.example.TBTDD.persistence.entity.Client;

import java.math.BigDecimal;

public class ClientDTO {

private int clientId;
private String ClientName;

private String contactName;

private String contactLastName;

private String phone;

private String fax;

private String addressLine;

private String addressLine2;

private String city;

private String region;

private String country;

private String zipCode;

private BigDecimal creditLimit;


    public ClientDTO() {
    }

    public ClientDTO(int clientId, String clientName, String contactName, String contactLastName, String phone, String fax, String addressLine, String addressLine2, String city, String region, String country, String zipCode, BigDecimal creditLimit) {
        this.clientId = clientId;
        ClientName = clientName;
        this.contactName = contactName;
        this.contactLastName = contactLastName;
        this.phone = phone;
        this.fax = fax;
        this.addressLine = addressLine;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.region = region;
        this.country = country;
        this.zipCode = zipCode;
        this.creditLimit = creditLimit;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public ClientDTO toDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientId(client.getClientId());
        clientDTO.setClientName(client.getClientName());
        clientDTO.setContactName(client.getContactName());
        clientDTO.setContactLastName(client.getContactLastName());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setFax(client.getFax());
        clientDTO.setAddressLine(client.getAddressLine1());
        clientDTO.setAddressLine2(client.getAddressLine2());
        clientDTO.setCity(client.getCity());
        clientDTO.setRegion(client.getRegion());
        clientDTO.setCountry(client.getCountry());
        clientDTO.setZipCode(client.getZipCode());
        clientDTO.setCreditLimit(client.getCreditLimit());
        return clientDTO;
    }

    public Client toEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setClientId(clientDTO.getClientId());
        client.setClientName(clientDTO.getClientName());
        client.setContactName(clientDTO.getContactName());
        client.setContactLastName(clientDTO.getContactLastName());
        client.setPhone(clientDTO.getPhone());
        client.setFax(clientDTO.getFax());
        client.setAddressLine1(clientDTO.getAddressLine());
        client.setAddressLine2(clientDTO.getAddressLine2());
        client.setCity(clientDTO.getCity());
        client.setRegion(clientDTO.getRegion());
        client.setCountry(clientDTO.getCountry());
        client.setZipCode(clientDTO.getZipCode());
        client.setCreditLimit(clientDTO.getCreditLimit());
        return client;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "clientId=" + clientId +
                ", ClientName='" + ClientName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", addressLine='" + addressLine + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", creditLimit=" + creditLimit +
                '}';
    }
}
