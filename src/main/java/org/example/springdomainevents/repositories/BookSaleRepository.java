package org.example.springdomainevents.repositories;

import org.example.springdomainevents.entity.BookSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookSaleRepository extends JpaRepository<BookSale, Long> {
}
