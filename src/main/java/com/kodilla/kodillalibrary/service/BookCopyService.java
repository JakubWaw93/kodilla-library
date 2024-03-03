package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.controller.BookCopyNotFoundException;
import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.repository.BookCopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCopyService {

    private final BookCopyRepository repository;

    public List<BookCopy> getAllBookCopiesByTitleId(final Long titleId) throws BookCopyNotFoundException {
        try {
            return repository.findAllByTitleId(titleId);
        } catch (EmptyResultDataAccessException e) {
            throw  new BookCopyNotFoundException();
        }
    }

    public BookCopy getBookCopy(final long bookCopyId) throws BookCopyNotFoundException {
        return repository.findById(bookCopyId).orElseThrow(BookCopyNotFoundException::new);
    }

    public BookCopy saveBookCopy(final BookCopy bookCopy) {
        return repository.save(bookCopy);
    }

    public void deleteBookCopy(final long bookCopyId) throws BookCopyNotFoundException {
        try {
            repository.deleteById(bookCopyId);
        } catch (EmptyResultDataAccessException e) {
            throw new BookCopyNotFoundException();
        }
    }

    public long countByTitleId(final Long titleId) {
        return repository.countByTitleId(titleId);
    }
}
