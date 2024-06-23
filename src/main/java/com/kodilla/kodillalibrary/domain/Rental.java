package com.kodilla.kodillalibrary.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookCopy_id", nullable = false)
    private BookCopy bookCopy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reader_id", referencedColumnName = "reader_id", nullable = false)
    @NotNull
    private Reader reader;

    @Column(name = "date_of_rent", nullable = false)
    @NotNull
    private LocalDate dateOfRent;

    @Column(name = "date_of_return")
    private LocalDate dateOfReturn;

}
