package com.springg.demo.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "customer")

public class Customer {

    @OneToMany(mappedBy="customer")
    private Set<Order> orders;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id",length = 45)
    private int customerId;

    @Column(name = "customer_name",length =100,nullable = false)
    private String customerName;

    @Column(name = "customer_address",length = 255,nullable = false)
    private String customerAddress;

    @Column(name = "customer_salary",length = 255,nullable = false)
    private double customerSalary;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="contact_numbers",length = 20)
    private ArrayList  customerNumber;

    @Column(name = "customer_nic")
    private String customerNIC;

    @Column(name = "active_state", columnDefinition = "TINYINT DEFAULT 0")
    private boolean active;


    public Customer(int customerId, String customerName, String customerAddress, double customerSalary, ArrayList customerNumber, String customerNIC, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.customerNumber = customerNumber;
        this.customerNIC = customerNIC;
        this.active = active;
    }

    public Customer() {

    }

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public ArrayList getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(ArrayList customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", customerNumber=" + customerNumber +
                ", customerNIC='" + customerNIC + '\'' +
                ", active=" + active +
                '}';
    }
}
