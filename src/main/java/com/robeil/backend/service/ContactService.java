package com.robeil.backend.service;

import com.robeil.backend.entity.Contact;

import java.util.List;

public interface ContactService {

    Contact addNewContact(Contact contact);
    Contact getTheNewContact(Long id);

    List<Contact> getAllContacts();
}
