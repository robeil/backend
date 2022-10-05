package com.robeil.backend.service.impl;

import com.robeil.backend.entity.Contact;
import com.robeil.backend.repository.ContactRepository;
import com.robeil.backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact addNewContact(Contact contact) {
        var newContact = contactRepository.save(contact);
//        newContact.setContactedTime(LocalDate.now());
        return newContact;
    }

    @Override
    public Contact getTheNewContact(Long id) {
        var getNewContact = contactRepository.findById(id).get();
//        var date = addNewContact(getNewContact).getContactedTime();
//        getNewContact.setContactedTime(date);
        return getNewContact;
    }

    @Override
    public List<Contact> getAllContacts(){
        var getAllContacts = contactRepository.findAll();
        return getAllContacts;
    }
}
