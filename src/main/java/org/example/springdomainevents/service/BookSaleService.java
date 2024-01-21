package org.example.springdomainevents.service;

import org.example.springdomainevents.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class BookSaleService {

    private final BookRepository bookRepository;

    public BookSaleService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void sellBook(Long bookId) {
        var book = bookRepository.findById(bookId).orElseThrow(() -> new NoSuchElementException("Book is not found. bookId: " + bookId));
        book.sell();
        bookRepository.save(book);
    }
}
