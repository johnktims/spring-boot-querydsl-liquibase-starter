package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface AddressRepository extends JpaRepository<Address, Integer>, QueryDslPredicateExecutor<Address> {

}
