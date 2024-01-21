package org.example.springdomainevents.repositories;

import org.example.springdomainevents.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
