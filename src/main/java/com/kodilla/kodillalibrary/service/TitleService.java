package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.controller.exception.TitleNotFoundException;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TitleService {

    private final TitleRepository repository;

    public List<Title> getAllTitles() {
        return repository.findAll();
    }

    public List<Title> getAllTitlesByAuthor(final String author) {
        return repository.findAllByAuthorContainingIgnoreCase(author);
    }

    public List<Title> getAllTitlesByTheTitle(final String theTitle) {
        return repository.findAllByTheTitleContainingIgnoreCase(theTitle);
    }

    public Title getTitle(final long titleId) throws TitleNotFoundException {
        return repository.findById(titleId).orElseThrow(TitleNotFoundException::new);
    }

    public Title saveTitle(final Title title) {
        return repository.save(title);
    }

    public void deleteTitle(final long titleId) throws TitleNotFoundException {
        try {
            repository.deleteById(titleId);
        } catch (EmptyResultDataAccessException e) {
            throw new TitleNotFoundException();
        }
    }
}
