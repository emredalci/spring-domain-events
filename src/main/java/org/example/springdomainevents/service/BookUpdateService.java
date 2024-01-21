package org.example.springdomainevents.service;

import jakarta.transaction.Transactional;
import org.example.springdomainevents.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BookUpdateService {

    private final BookRepository bookRepository;

    public BookUpdateService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void updateBookInfo(Long bookId, String name, String description) {
        var book = bookRepository.findById(bookId).orElseThrow(() -> new NoSuchElementException("Book is not found. bookId: " + bookId));
        book.changeInfo(name, description);
        bookRepository.save(book);
    }
}
