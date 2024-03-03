package com.kodilla.kodillalibrary.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @NotNull
    private Long id;

    @Column(name = "title")
    @NotNull
    private String theTitle;

    @Column(name = "author")
    @NotNull
    private String author;

    @Column(name = "publicationYear")
    @NotNull
    private int publicationYear;


}
