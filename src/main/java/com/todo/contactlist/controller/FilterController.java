package com.todo.contactlist.controller;

import com.todo.contactlist.dto.RequestDto;
import com.todo.contactlist.entity.Contact;
import com.todo.contactlist.repository.ContactRepository;
import com.todo.contactlist.service.FilterSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filter")
public class FilterController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private FilterSpecification<Contact> contactfilterSpecification;

//    @GetMapping("/{name}")
//    public Contact getContactByName(@PathVariable(name = "name") String name) {
//        return contactRepository.findByName(name);
//    }
//
//    @GetMapping("/phone/{phone}")
//    public List<Contact> getContactByPhone(@PathVariable(name = "phone") String phone) {
//        return contactRepository.findByPhone(phone);
//    }
//
//    @GetMapping("/email/{email}")
//    public List<Contact> getContactByEmail(@PathVariable(name = "email") String email) {
//        return contactRepository.findByEmail(email);
//    }
//
//    @GetMapping("/book/{id}")
//    public List<Contact> getContactByBookId(@PathVariable(name = "id") Integer id) {
//        return contactRepository.findByBookId(id);
//    }
//
//    @PostMapping("/specification")
//    public List<Contact> getStudents(@RequestBody RequestDto requestDto) {
//        return null;
//
//    }

    @PostMapping("/specification")
    public List<Contact> getContacts(@RequestBody RequestDto requestDto) {
        Specification<Contact> searchSpecification = contactfilterSpecification.getSearchSpecification(requestDto.getSearchRequestDto(),
                requestDto.getGlobalOperator());
        return contactRepository.findAll(searchSpecification);
    }
}
