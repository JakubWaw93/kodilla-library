package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.domain.Reader;
import com.kodilla.kodillalibrary.domain.Rental;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RentalRepository extends CrudRepository<Rental, Long> {

    @Override
    List<Rental> findAll();

    List<Rental> findAllByReaderId(Long readerId);

    @Override
    Optional<Rental> findById(Long RentalId);

    @Override
    Rental save(Rental rental);

    @Override
    void deleteById(Long RentalId);

    Long countAllByReaderId(Long readerId);

}
