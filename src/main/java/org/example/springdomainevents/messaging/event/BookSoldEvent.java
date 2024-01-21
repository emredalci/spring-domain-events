package org.example.springdomainevents.messaging.event;

import org.example.springdomainevents.entity.BookSale;
import org.springframework.context.ApplicationEvent;

public class BookSoldEvent extends ApplicationEvent {

    public BookSoldEvent(BookSale bookSale) {
        super(bookSale);
    }

    public Long getBookId() {
        var bookSale = (BookSale) source;
        return bookSale.getBook().getId();
    }


    public BookSale getBookSale() {
        return (BookSale) source;
    }


}
