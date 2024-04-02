package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.controller.exception.BookCopyNotFoundException;
import com.kodilla.kodillalibrary.controller.exception.ReaderNotFoundException;
import com.kodilla.kodillalibrary.domain.*;
import com.kodilla.kodillalibrary.repository.BookCopyRepository;
import com.kodilla.kodillalibrary.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RentalMapper {

    private final BookCopyRepository bookCopyRepository;
    private final ReaderRepository readerRepository;

    public Rental mapToRental(final RentalDto rentalDto) throws ReaderNotFoundException, BookCopyNotFoundException {
        Rental rental = new Rental();
        rental.setId(rentalDto.getId());
        rental.setBookCopy(bookCopyRepository.findById(rentalDto.getBookCopyId()).orElseThrow(BookCopyNotFoundException::new));
        rental.setReader(readerRepository.findById(rentalDto.getReaderId()).orElseThrow(ReaderNotFoundException::new));
        rental.setDateOfRent(rentalDto.getDateOfRent());
        rental.setDateOfReturn(rentalDto.getDateOfReturn());
        return rental;
    }

    public RentalDto mapToRentalDto(final Rental rental) {
        RentalDto rentalDto = new RentalDto();
        rentalDto.setId(rental.getId());
        rentalDto.setBookCopyId(rental.getBookCopy().getId());
        rentalDto.setReaderId(rental.getReader().getId());
        rentalDto.setDateOfRent(rental.getDateOfRent());
        rentalDto.setDateOfReturn(rental.getDateOfReturn());
        return rentalDto;
    }

    public List<RentalDto> mapToRentalDtoList(final List<Rental> rentalDtoList) {
        return rentalDtoList.stream()
                .map(this::mapToRentalDto)
                .toList();
    }
}
