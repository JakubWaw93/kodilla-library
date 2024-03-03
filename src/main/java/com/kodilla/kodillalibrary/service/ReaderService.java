package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.controller.ReaderNotFoundException;
import com.kodilla.kodillalibrary.domain.Reader;
import com.kodilla.kodillalibrary.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.lang.ref.PhantomReference;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository repository;

    public List<Reader> getAllReaders() {
        return repository.findAll();
    }

    public Reader getReader(final long readerId) throws ReaderNotFoundException {
        return repository.findById(readerId).orElseThrow(ReaderNotFoundException::new);
    }

    public Reader saveReader(final Reader reader) {
        return repository.save(reader);
    }

    public void deleteReader(final long readerId) throws ReaderNotFoundException {
        try {
            repository.deleteById(readerId);
        } catch (EmptyResultDataAccessException e) {
            throw new ReaderNotFoundException();
        }
    }
}
