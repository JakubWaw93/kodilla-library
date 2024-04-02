package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalDto {

    private Long id;
    private Long bookCopyId;
    private Long readerId;
    private LocalDate dateOfRent;
    private LocalDate dateOfReturn;

}
