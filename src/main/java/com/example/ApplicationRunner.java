package com.example;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mysema.query.jpa.impl.JPAQuery;

@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @PersistenceContext
    EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Person person1 = personRepository.save(new Person("person1", 20, new Date(), new HashSet<Address>()));
        Person person2 = personRepository.save(new Person("person2", 30, new Date(), new HashSet<Address>()));

        addressRepository.save(new Address(person1, "some street 1", 12345));
        addressRepository.save(new Address(person2, "some street 2", 54321));

        for (Person person : personRepository.findAll(QPerson.person.name.eq("person1"))) {
            logger.info("{}: {}", person.getName(), person.getAge());
        }

        JPAQuery query = new JPAQuery(em);
        for (Person person : query.from(QPerson.person).list(QPerson.person)) {
            logger.info("{}: {}", person.getName(), person.getBirthday());
        }
    }
}
