package org.example.springdomainevents.messaging.listener;

import org.example.springdomainevents.messaging.event.BookChangedInfoEvent;
import org.example.springdomainevents.service.EmailService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.text.MessageFormat;

@Component
public class BookChangedInfoEventListener {

    private final EmailService emailService;

    public BookChangedInfoEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void changeInfo(BookChangedInfoEvent bookChangedInfoEvent) {
        emailService.send(bookChangedInfoEvent.getBook().getAuthor().getEmail(),
                MessageFormat.format("Book info has just changed. Book id : {0}", bookChangedInfoEvent.getBook().getId()));
    }
}
