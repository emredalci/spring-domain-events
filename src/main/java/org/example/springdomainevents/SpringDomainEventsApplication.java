package org.example.springdomainevents;

import org.example.springdomainevents.repositories.AuthorRepository;
import org.example.springdomainevents.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringDomainEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDomainEventsApplication.class, args);
    }

}

