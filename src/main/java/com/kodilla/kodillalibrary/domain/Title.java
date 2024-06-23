package com.kodilla.kodillalibrary.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="titles")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "title_id", unique = true)
    private Long id;

    @Column(name = "title", nullable = false)
    private String theTitle;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "publication_year", nullable = false)
    private int publicationYear;

    @OneToMany(targetEntity = BookCopy.class,
    mappedBy = "title",
    cascade = CascadeType.PERSIST,
    fetch = FetchType.EAGER)
    private List<BookCopy> bookCopies = new ArrayList<>();



}
