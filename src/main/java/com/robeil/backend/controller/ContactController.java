package com.robeil.backend.controller;

import com.robeil.backend.entity.Contact;
import com.robeil.backend.service.ContactService;
import com.robeil.backend.service.EmailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@CrossOrigin
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private EmailSenderService senderService;


    Logger logger = LoggerFactory.getLogger(ContactController.class);


    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() {
        senderService.sendEmail(
                "aregawirobeil1@gmail.com",
                "From portfolio message",
                "Hi Robeil, " +
                        " Some one send you message from your portfolio");
    }

    @PostMapping
    public ResponseEntity<Contact> addNewContact(@RequestBody Contact contact) {
        //sending message each time get a new contact
        sendEmail();
        var newContact = contactService.addNewContact(contact);
        return ResponseEntity.ok(newContact);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getNewContact(@PathVariable Long id) {

        var getNewContact = contactService.getTheNewContact(id);
        logger.info("Retrieving user :- " + getNewContact.getFullName().toLowerCase());
        return ResponseEntity.ok(getNewContact);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        var allContacts = contactService.getAllContacts();
        logger.info("Retrieving all the users :- " + allContacts.toArray());
        return ResponseEntity.ok(allContacts);
    }
}
