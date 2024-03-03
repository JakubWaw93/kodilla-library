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
@Entity(name = "book_Copies")
public class BookCopy {

    @Id
    @GeneratedValue
    @NonNull
    private Long id;

    @Column(name = "title_Id")
    @NonNull
    private Long titleId;

    @Column(name = "status")
    @NonNull
    private String status;
}
