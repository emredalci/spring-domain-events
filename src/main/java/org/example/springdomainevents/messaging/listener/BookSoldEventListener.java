package org.example.springdomainevents.messaging.listener;

import org.example.springdomainevents.messaging.event.BookSoldEvent;
import org.example.springdomainevents.service.EmailService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.text.MessageFormat;

@Component
public class BookSoldEventListener {

    private final EmailService emailService;

    public BookSoldEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void sendEmail(BookSoldEvent bookSoldEvent) {
        emailService.send(bookSoldEvent.getBookSale().getBook().getAuthor().getEmail(),
                MessageFormat.format("Book has just sold. Book id : {0}", bookSoldEvent.getBookId()));
    }
}
