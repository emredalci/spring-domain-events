package org.example.springdomainevents.repositories;

import org.example.springdomainevents.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
