package com.example.library.models;

import com.example.library.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "publication_year")
    private int publicationYear;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User client;

    @Column(name = "borrow_date")
    private LocalDate borrowDate;
}
