package org.example.springdomainevents.messaging.event;

import org.example.springdomainevents.entity.Book;
import org.springframework.context.ApplicationEvent;

public class BookChangedInfoEvent extends ApplicationEvent {

    public BookChangedInfoEvent(Book source) {
        super(source);
    }

    public Book getBook() {
        return (Book) source;
    }
}
