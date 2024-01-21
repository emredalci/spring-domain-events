package org.example.springdomainevents.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    public void send(String address, String message) {
        LOGGER.info(MessageFormat.format("to: {0} ; message: {1}", address, message));
    }
}
