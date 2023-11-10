package com.jdt.itcg.demo.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {

    @Column(name = "address_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String street;

    @Column
    private String extNum;

    @Column
    private String intNumber;

    @Column
    private String zipCode;

    @Column
    private String city;

    @Column
    private String county;

    @CreatedDate
    @Column
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column
    private LocalDateTime updateAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getExtNum() {
        return extNum;
    }

    public void setExtNum(String extNum) {
        this.extNum = extNum;
    }

    public String getIntNumber() {
        return intNumber;
    }

    public void setIntNumber(String intNumber) {
        this.intNumber = intNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(extNum, address.extNum) && Objects.equals(intNumber, address.intNumber) && Objects.equals(zipCode, address.zipCode) && Objects.equals(city, address.city) && Objects.equals(county, address.county) && Objects.equals(createAt, address.createAt) && Objects.equals(updateAt, address.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, extNum, intNumber, zipCode, city, county, createAt, updateAt);
    }
}
