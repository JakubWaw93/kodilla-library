package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderDto {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate joined;
    private List<Long> rentalsIds = new ArrayList<>();

}
