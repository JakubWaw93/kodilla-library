package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.controller.RentalNotFoundException;
import com.kodilla.kodillalibrary.domain.Rental;
import com.kodilla.kodillalibrary.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RentalService {

    private final RentalRepository repository;

    public List<Rental> getAllRentals() {
        return repository.findAll();
    }

    public List<Rental> getAllRentalsByReaderId(final Long readerId) {
        return repository.findAllByReaderId(readerId);
    }

    public Rental getRental(final Long rentalId) throws RentalNotFoundException {
        return repository.findById(rentalId).orElseThrow(RentalNotFoundException::new);
    }

    public Rental saveRental(final Rental rental) {
        return repository.save(rental);
    }

    public void deleteRental(final Long rentalId) throws RentalNotFoundException {
        try {
            repository.deleteById(rentalId);
        } catch (EmptyResultDataAccessException e) {
            throw new RentalNotFoundException();
        }
    }

    public Long countByReaderId (final Long readerId) {
        return repository.countAllByReaderId(readerId);
    }
}
