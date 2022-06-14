package lk.ijse.hibernate.entity;

import lk.ijse.hibernate.embeded.Name;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/*
    @author DanujaV
    @created 24/05/2022 - 10:49 AM
*/
@Entity(name = "customer")  //to change table name
public class Customer {
    @Id
    private String id;
    @Embedded   //for the embedded another class with entity class's property
    private Name name;
    @Column(name = "monthly_income")    // to change table column name only
    private double salary;
    private String address;
    @Transient  //to ignoring creating table column
    private String status;
    @CreationTimestamp  //set by default time
    private Date date;

    public Customer() {
    }

    public Customer(String id, Name name, double salary, String address, String status, Date date) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.status = status;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


