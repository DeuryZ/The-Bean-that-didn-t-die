package com.example.TBTDD.persistence.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cliente", length = 11)
    private Integer clientId;

    @Column(name = "nombre_cliente", length = 50)
    private String ClientName;

    @Column(name = "nombre_contacto" , length = 30, nullable = true)
    private String contactName;

    @Column(name = "apellido_contacto" , length = 30, nullable = true)
    private String contactLastName;

    @Column(name="telefono", length = 15)
    private String phone;

    @Column(name="fax", length = 15)
    private String fax;

    @Column(name="linea_direccion1", length = 50)
    private String addressLine1;

    @Column(name="linea_direccion2", length = 50, nullable = true)
    private String addressLine2;

    @Column(name="ciudad", length = 50)
    private String city;

    @Column(name="region", length = 50 , nullable = true)
    private String region;

    @Column(name="pais", length = 50, nullable = true)
    private String country;

    @Column(name="codigo_postal", length = 10, nullable = true)
    private String zipCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( referencedColumnName = "codigo_empleado", name="codigo_empleado_rep_ventas", nullable = true)
    private Employee salesRepEmployeeId;

    @Column(name="limite_credito", precision = 15, scale = 2, nullable = true)
    private Double creditLimit;

    public Client() {
    }

    public Client(Integer clientId, String clientName, String contactName, String contactLastName, String phone, String fax, String addressLine1, String addressLine2, String city, String region, String country, String zipCode, Employee salesRepEmployeeId, Double creditLimit) {
        this.clientId = clientId;
        ClientName = clientName;
        this.contactName = contactName;
        this.contactLastName = contactLastName;
        this.phone = phone;
        this.fax = fax;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.region = region;
        this.country = country;
        this.zipCode = zipCode;
        this.salesRepEmployeeId = salesRepEmployeeId;
        this.creditLimit = creditLimit;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
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

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setDirectionLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
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

    public Employee getSalesRepEmployeeId() {
        return salesRepEmployeeId;
    }

    public void setSalesRepEmployeeId(Employee salesRepEmployeeId) {
        this.salesRepEmployeeId = salesRepEmployeeId;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
