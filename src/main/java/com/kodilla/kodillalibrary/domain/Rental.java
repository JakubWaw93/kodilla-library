package com.kodilla.kodillalibrary.domain;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "bookCopyId")
    @NotNull
    private Long bookCopyId;

    @Column(name = "readerId")
    @NotNull
    private Long readerId;

    @Column(name = "dateOfRent")
    @NotNull
    private LocalDate dateOfRent;

    @Column(name = "dateOfReturn")
    private LocalDate dateOfReturn;

}
