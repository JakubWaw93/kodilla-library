package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.controller.exception.RentalNotFoundException;
import com.kodilla.kodillalibrary.controller.exception.TitleNotFoundException;
import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.domain.BookCopyDto;
import com.kodilla.kodillalibrary.domain.Rental;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.repository.RentalRepository;
import com.kodilla.kodillalibrary.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookCopyMapper {

    private final TitleRepository titleRepository;
    private final RentalRepository rentalRepository;

    public BookCopy mapToBookCopy(final BookCopyDto bookCopyDto) throws TitleNotFoundException, RentalNotFoundException {
        BookCopy bookCopy = new BookCopy();
        bookCopy.setId(bookCopyDto.getId());
        Title title = titleRepository.findById(bookCopyDto.getTitleId()).orElseThrow(TitleNotFoundException::new);
        bookCopy.setTitle(title);
        bookCopy.setStatus(bookCopyDto.getStatus());
        List<Rental> rentals = bookCopyDto.getRentalsIds().stream()
                .map(rentalRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        bookCopy.setRentals(rentals);
        return bookCopy;
    }

    public BookCopyDto mapToBookCopyDto(final BookCopy bookCopy) {
        BookCopyDto bookCopyDto = new BookCopyDto();
        bookCopyDto.setId(bookCopy.getId());
        bookCopyDto.setTitleId(bookCopy.getTitle().getId());
        bookCopyDto.setStatus(bookCopy.getStatus());
        List<Long> rentalsIds = bookCopy.getRentals().stream().map(Rental::getId).toList();
        bookCopyDto.setRentalsIds(rentalsIds);
        return bookCopyDto;
    }

    public List<BookCopyDto> mapToBookCopyDtoList(final List<BookCopy> bookCopyList) {
        return bookCopyList.stream()
                .map(this::mapToBookCopyDto)
                .toList();
    }

}
