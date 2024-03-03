package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.domain.Reader;
import com.kodilla.kodillalibrary.domain.Title;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TitleRepository extends CrudRepository<Title, Long> {

    @Override
    List<Title> findAll();

    List<Title> findAllByAuthorContainingIgnoreCase(String author);

    List<Title> findAllByTheTitleContainingIgnoreCase(String title);

    @Override
    Optional<Title> findById(Long TitleId);

    @Override
    Title save(Title title);

    @Override
    void deleteById(Long TitleId);
}
