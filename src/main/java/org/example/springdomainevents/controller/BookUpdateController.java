package org.example.springdomainevents.controller;

import org.example.springdomainevents.service.BookUpdateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("change-info")
public class BookUpdateController {

    private final BookUpdateService bookUpdateService;

    public BookUpdateController(BookUpdateService bookUpdateService) {
        this.bookUpdateService = bookUpdateService;
    }

    @PostMapping("/{bookId}")
    public void update(@PathVariable Long bookId, @RequestParam String name, @RequestParam String description) {
        bookUpdateService.updateBookInfo(bookId, name, description);
    }
}
