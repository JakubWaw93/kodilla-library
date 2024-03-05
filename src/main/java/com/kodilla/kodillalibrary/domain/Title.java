package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name="titles")
public class Title {

    @Id
    @GeneratedValue()
    @NotNull
    private Long id;

    @Column(name = "title")
    @NotNull
    private String theTitle;

    @Column(name = "author")
    @NotNull
    private String author;

    @Column(name = "publication_year")
    @NotNull
    private int publicationYear;



}
