package com.em.employee_service.dto;

import com.em.employee_service.validators.CreateEmployeeValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmployeeRequestDTO {
    @NotBlank(message="Name is mandatory")
    @Size(max=70,message="Name should be less than 70 characters")
    private String name;

    @NotBlank(message="Email is mandatory")
    @Email(message="Email should be valid")
    private String email;

    @NotBlank(message="Address is mandatory")
    private String address;

    @NotBlank(message="Date of birth is mandatory")
    private String dateOfBirth;

    @NotBlank(groups = CreateEmployeeValidationGroup.class, message="Register date is mandatory")
    private String registerDate;

    @NotBlank(message="Department is mandatory")
    private String department;

    @NotBlank(message="Designation is mandatory")
    private String designation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
