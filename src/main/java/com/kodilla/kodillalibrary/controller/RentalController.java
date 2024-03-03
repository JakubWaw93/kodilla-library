package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.Rental;
import com.kodilla.kodillalibrary.domain.RentalDto;
import com.kodilla.kodillalibrary.mapper.RentalMapper;
import com.kodilla.kodillalibrary.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/v1/rentals")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RentalController {

    private final RentalService service;
    private final RentalMapper mapper;
    private final Logger LOGGER = LoggerFactory.getLogger(RentalController.class);

    @GetMapping
    public ResponseEntity<List<RentalDto>> getRentals() {
        List<Rental> rentals = service.getAllRentals();
        return ResponseEntity.ok(mapper.mapToRentalDtoList(rentals));
    }

    @GetMapping(value = "/reader/{readerId}")
    public ResponseEntity<List<RentalDto>> getRentalsByReaderId(@PathVariable Long readerId) throws RentalNotFoundException {
        LOGGER.info("This reader has: " + service.countByReaderId(readerId) + " rental(s).");
        return ResponseEntity.ok(mapper.mapToRentalDtoList(service.getAllRentalsByReaderId(readerId)));
    }

    @GetMapping(value = "/{rentalId}")
    public ResponseEntity<RentalDto> getRental(@PathVariable Long rentalId) throws RentalNotFoundException {
        return ResponseEntity.ok(mapper.mapToRentalDto(service.getRental(rentalId)));
    }

    @PutMapping
    public ResponseEntity<RentalDto> updateRental(@RequestBody RentalDto rentalDto) {
        Rental rental = mapper.mapToRental(rentalDto);
        Rental savedRental = service.saveRental(rental);
        return ResponseEntity.ok(mapper.mapToRentalDto(savedRental));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRental(@RequestBody RentalDto rentalDto) {
        Rental rental = mapper.mapToRental(rentalDto);
        service.saveRental(rental);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{rentalId}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long rentalId) throws RentalNotFoundException {
        service.deleteRental(rentalId);
        return ResponseEntity.ok().build();

    }


}
