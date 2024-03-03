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
@Entity(name = "bookCopies")
public class BookCopy {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "titleId")
    @NotNull
    private Long titleId;

    @Column(name = "status")
    @NotNull
    private String status;
}
