package com.todo.contactlist.service;

import com.todo.contactlist.entity.Contact;
import com.todo.contactlist.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.sql.Time;
import java.time.Instant;

@AllArgsConstructor
@Service
public class ContactService {


    private final ContactRepository contactRepository;


    public Iterable<Contact> findAll(@PageableDefault(size = 5, page = 0,direction = Sort.Direction.ASC, sort = "name") Pageable pageable){

        return contactRepository.findAll(pageable);
    }



    public Iterable<Contact> listWithPage(@PageableDefault(size = 5, page = 0, direction = Sort.Direction.ASC, sort = "id") Pageable pageable, int pageNum) {
        return contactRepository.findAll(pageable.withPage(pageNum));
    }


    public Contact findById(Integer id) {
        return contactRepository.findById(id).orElse(null);
    }

    public Contact create(Contact contact) {
        contact.setCreatedAt(Time.from(Instant.now()));
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

