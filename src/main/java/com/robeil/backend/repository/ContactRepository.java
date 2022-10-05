package com.robeil.backend.repository;

import com.robeil.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
//@Repository
//public interface ContactRepository extends MongoRepository<Contact, Long> {

}
