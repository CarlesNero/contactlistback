package com.todo.contactlist.service;

import com.todo.contactlist.entity.Contact;
import com.todo.contactlist.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {


    private final ContactRepository contactRepository;


    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }


    public Contact findById(Integer id) {
        return contactRepository.findById(id).orElse(null);
    }

    public Contact create(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        contact.setPhone("número no disponible");
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, Contact form) {

        Contact contactDb = findById(id);
        contactDb.setName(form.getName());
        contactDb.setPhone(form.getPhone());
        contactDb.setEmail(form.getEmail());

        return contactRepository.save(contactDb);
    }

    public void delete(Integer id) {
        Contact contactDb = findById(id);
        contactRepository.delete(contactDb);

    }
}

