package org.example.springdomainevents;

import org.example.springdomainevents.entity.Author;
import org.example.springdomainevents.entity.Book;
import org.example.springdomainevents.repositories.AuthorRepository;
import org.example.springdomainevents.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class DataBootstrap implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("Beverly", "Micah", "sit@protonmail.com");
        Author author2 = new Author("Sigourney", "Yasir", "ante@icloud.org");

        authorRepository.save(author1);
        authorRepository.save(author2);

        Book book1 = new Book("book1", "description", OffsetDateTime.now(), null, author1, 100);
        Book book2 = new Book("book12", "description2", OffsetDateTime.now(), null, author2, 200);

        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
