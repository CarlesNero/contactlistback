package com.todo.contactlist.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity(name = "Book")

public class Book {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_BOOK")
    @SequenceGenerator(sequenceName = "bookSequence", allocationSize = 1, name = "ID_BOOK")
    private Integer id_book;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false, unique = false)
    private String autor;
    @Column(nullable = false, unique = false)
    private String editorial;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column (nullable = false , unique = true)
    private int ownerId;


    public Book( String tittle, String autor, String editorial, String isbn, int ownerId) {

        this.title = tittle;
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
        this.ownerId = ownerId;
    }

    public Book() {

    }
}
