package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.domain.Reader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReaderRepository extends CrudRepository<Reader, Long> {

    @Override
    List<Reader> findAll();

    @Override
    Optional<Reader> findById(Long ReaderId);

    @Override
    Reader save(Reader reader);

    @Override
    void deleteById(Long ReaderId);

}
