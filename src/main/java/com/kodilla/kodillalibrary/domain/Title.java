package com.kodilla.kodillalibrary.domain;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name="titles")
public class Title {

    @Id
    @GeneratedValue
    @NonNull
    private Long id;

    @Column(name = "title")
    @NonNull
    private String theTitle;

    @Column(name = "author")
    @NonNull
    private String author;

    @Column(name = "publication_year")
    @NonNull
    private int publicationYear;


}
