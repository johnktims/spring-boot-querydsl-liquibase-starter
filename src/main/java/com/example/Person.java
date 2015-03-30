package com.example;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class Person implements java.io.Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;
    private Set<Address> addresses = new HashSet<Address>(0);

    public Person() {
    }

    public Person(String name, Integer age, Date birthday, Set<Address> addresses) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.addresses = addresses;
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


    @Column(name = "NAME", unique = true, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "AGE")
    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BIRTHDAY", length = 23)
    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    public Set<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
