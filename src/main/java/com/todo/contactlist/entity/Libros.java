package com.todo.contactlist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "numId")
    @SequenceGenerator(sequenceName = "Libros_SEQ", name = "numId", allocationSize = 1)
    private Integer id;
    @Column (nullable = false , unique = true)
    private String titulo;
    @Column (nullable = false, unique = false)
    private String contacto;
    @Column (nullable = false, unique = true)
    private String autor;
}
