package com.kodilla.kodillalibrary.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue
    @NonNull
    private Long id;

    @Column(name = "book_copy_id")
    @NonNull
    private Long bookCopyId;

    @Column(name = "reader_id")
    @NonNull
    private Long readerId;

    @Column(name = "date_Of_Rent")
    @NonNull
    private LocalDate dateOfRent;

    @Column(name = "date_Of_Return")
    private LocalDate dateOfReturn;

}
