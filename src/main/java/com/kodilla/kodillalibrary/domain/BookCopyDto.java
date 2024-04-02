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
public class BookCopyDto {

    private Long id;
    private Long titleId;
    private BookStatus status = BookStatus.AVAILABLE;
    private List<Long> rentalsIds = new ArrayList<>();

}
