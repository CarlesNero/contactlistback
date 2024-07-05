package com.todo.contactlist.controller;

import com.todo.contactlist.entity.Contact;
import com.todo.contactlist.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.Instant;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public Iterable<Contact> list(@PageableDefault(size = 5, page = 0, direction = Sort.Direction.ASC, sort = "id") Pageable pageable) {
        return contactService.findAll(pageable);
    }

    @GetMapping("/page/{pageNum}")
    public Iterable<Contact> listWithPage(@PageableDefault(size = 5, page = 0, direction = Sort.Direction.ASC, sort = "id") Pageable pageable, @PathVariable int pageNum) {
        return contactService.findAll(pageable.withPage(pageNum));
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id){
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody Contact contact){
        contact.setCreatedAt(Time.from(Instant.now()));
        return contactService.create(contact);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id,
             @RequestBody Contact form){



        return contactService.update(id, form);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        contactService.delete(id);
    }

}
