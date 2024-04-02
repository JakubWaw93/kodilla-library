package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.*;
import com.kodilla.kodillalibrary.repository.RentalRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReaderMapper {

    private final RentalRepository rentalRepository;

    public Reader mapToReader(final ReaderDto readerDto) {
        Reader reader = new Reader();
        reader.setId(readerDto.getId());
        reader.setFirstName(readerDto.getFirstName());
        reader.setLastName(readerDto.getLastName());
        reader.setJoined(readerDto.getJoined());
        List<Rental> rentals = readerDto.getRentalsIds().stream()
                .map(rentalRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        reader.setRentals(rentals);
        return reader;
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        ReaderDto readerDto = new ReaderDto();
        readerDto.setId(reader.getId());
        readerDto.setFirstName(reader.getFirstName());
        readerDto.setLastName(reader.getLastName());
        readerDto.setJoined(reader.getJoined());
        List<Long> rentalsIds = reader.getRentals().stream()
                .map(Rental::getId)
                .toList();
        readerDto.setRentalsIds(rentalsIds);
        return readerDto;
    }
    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                .map(this::mapToReaderDto)
                .toList();
    }

}
