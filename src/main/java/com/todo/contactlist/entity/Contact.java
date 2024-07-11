package com.todo.contactlist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    @Column (name = "BOOK", nullable = true, unique = false)
    private Integer bookId;
    @Column(name = "CREATED_AT", nullable = false, unique = false)
    @Temporal(TemporalType.DATE)
    private Date createdAt;




}
