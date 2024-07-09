package com.todo.contactlist.repository;

import com.todo.contactlist.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>, JpaSpecificationExecutor<Contact> {

Contact findByName(String name);

List<Contact> findByEmail(String email);

List<Contact> findByPhone(String phone);

List<Contact> findByBookId(Integer id);


}
