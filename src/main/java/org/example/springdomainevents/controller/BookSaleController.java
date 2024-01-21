package org.example.springdomainevents.controller;

import org.example.springdomainevents.service.BookSaleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sale")
public class BookSaleController {

    private final BookSaleService bookSaleService;

    public BookSaleController(BookSaleService bookSaleService) {
        this.bookSaleService = bookSaleService;
    }

    @PostMapping("/{bookId}")
    public void sale(@PathVariable Long bookId) {
        bookSaleService.sellBook(bookId);
    }
}
