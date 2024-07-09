package com.todo.contactlist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KJWGDHKEJW")
    @SequenceGenerator(sequenceName = "CONTANCT_SEQ", name = "KJWGDHKEJW", allocationSize = 1)
    private Integer id;
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;
    @Column(name = "PHONE", nullable = false, unique = true)
    private String phone;
    @Column (name = "BOOK", nullable = false, unique = false)
    private Integer bookId;
    @Column(name = "CREATED_AT", nullable = false, unique = false)
    @Temporal(TemporalType.DATE)
    private Date createdAt;


    public Contact(Integer id, String name, String email, String phone, Integer bookId, Date createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bookId = bookId;
        this.createdAt = createdAt;
    }

    public Contact() {
    }
}
