package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TitleDto {

    private Long id;
    private String theTitle;
    private String author;
    private int publicationYear;
    private List<Long> bookCopiesIds = new ArrayList<>();

}