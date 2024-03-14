package com.example.TBTDD.persistence.DTO;

public class EmployeeDTO {
    private Integer employeeId;
    private String employeeName;
    private String employeeLastName1;
    private String employeeLastName2;
    private String extension;
    private String email;

    private String jobTitle;


    public EmployeeDTO() {
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeLastName1='" + employeeLastName1 + '\'' +
                ", employeeLastName2='" + employeeLastName2 + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
