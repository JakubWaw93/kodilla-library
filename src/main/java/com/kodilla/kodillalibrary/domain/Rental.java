package com.kodilla.kodillalibrary.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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

    @Column(name = "book_copy_id")
    @NotNull
    private Long bookCopyId;

    @Column(name = "reader_id")
    @NotNull
    private Long readerId;

    @Column(name = "date_Of_Rent")
    @NotNull
    private LocalDate dateOfRent;

    @Column(name = "date_Of_Return")
    private LocalDate dateOfReturn;

}
