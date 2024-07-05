package com.todo.contactlist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KJWGDHKEJW")
    @SequenceGenerator(sequenceName = "CONTANCT_SEQ", name = "KJWGDHKEJW", allocationSize = 1)
    private Integer id;
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String phone;
    @NonNull
    @Temporal(TemporalType.DATE)
    private Date createdAt;


}
