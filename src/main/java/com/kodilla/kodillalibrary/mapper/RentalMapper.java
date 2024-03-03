package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalMapper {

    public Rental mapToRental(final RentalDto rentalDto) {
        return new Rental(
                rentalDto.getId(),
                rentalDto.getBookCopyId(),
                rentalDto.getReaderId(),
                rentalDto.getDateOfRent(),
                rentalDto.getDateOfReturn()
        );
    }

    public RentalDto mapToRentalDto(final Rental rental) {
        return  new RentalDto(
                rental.getId(),
                rental.getBookCopyId(),
                rental.getReaderId(),
                rental.getDateOfRent(),
                rental.getDateOfReturn()
        );
    }

    public List<RentalDto> mapToRentalDtoList(final List<Rental> rentalDtoList) {
        return rentalDtoList.stream()
                .map(this::mapToRentalDto)
                .toList();
    }
}
