package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RentalDto {

    private Long id;
    private Long bookCopyId;
    private Long readerId;
    private LocalDate dateOfRent;
    private LocalDate dateOfReturn;

}
