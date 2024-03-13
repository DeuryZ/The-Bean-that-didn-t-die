package com.example.TBTDD.persistence.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_empleado", length = 11)
    private Integer employeeId;

    @Column(name = "nombre", length = 50)
    private String employeeName;

    @Column(name = "apellido1", length = 50)
    private String employeeLastName1;

    @Column(name = "apellido2", length = 50, nullable = true)
    private String employeeLastName2;

    @Column(name = "extension", length = 10)
    private String extension;

    @Column(name = "email", length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_oficina")
    private Office officeCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_jefe", nullable = true)
    private Employee reportsTo;

    @Column(name = "puesto", length = 50, nullable = true)
    private String jobTitle;

    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, String employeeLastName1, String employeeLastName2, String extension, String email, Office officeCode, Employee reportsTo, String jobTitle) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeLastName1 = employeeLastName1;
        this.employeeLastName2 = employeeLastName2;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLastName1() {
        return employeeLastName1;
    }

    public void setEmployeeLastName1(String employeeLastName1) {
        this.employeeLastName1 = employeeLastName1;
    }

    public String getEmployeeLastName2() {
        return employeeLastName2;
    }

    public void setEmployeeLastName2(String employeeLastName2) {
        this.employeeLastName2 = employeeLastName2;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Office getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(Office officeCode) {
        this.officeCode = officeCode;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
