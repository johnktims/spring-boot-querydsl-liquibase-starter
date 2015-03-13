package com.example;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Address implements Serializable {

    private Integer id;
    private Person person;
    private String street;
    private Integer zipcode;

    public Address() {
    }

    public Address(Person person, String street, Integer zipcode) {
        this.person = person;
        this.street = street;
        this.zipcode = zipcode;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    public Person getPerson() {
        return this.person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    @Column(name = "STREET", length = 128)
    public String getStreet() {
        return this.street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "ZIPCODE")
    public Integer getZipcode() {
        return this.zipcode;
    }
    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }
}


