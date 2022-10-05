package com.robeil.backend.controller;

import com.robeil.backend.entity.Contact;
import com.robeil.backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@CrossOrigin
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact>  addNewContact(@RequestBody Contact contact){
      var newContact = contactService.addNewContact(contact);
     return ResponseEntity.ok(newContact);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact>  getNewContact(@PathVariable Long id){
    var getNewContact =  contactService.getTheNewContact(id);
        return ResponseEntity.ok(getNewContact);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts(){
        var allContacts = contactService.getAllContacts();
        return ResponseEntity.ok(allContacts);
    }
}
