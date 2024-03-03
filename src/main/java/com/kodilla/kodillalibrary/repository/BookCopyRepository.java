package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.BookCopy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {

    List<BookCopy> findAllByTitleId(Long titleId);

    @Override
    Optional<BookCopy> findById(Long BookCopyId);

    @Override
    BookCopy save(BookCopy bookCopy);

    @Override
    void deleteById(Long BookCopyId);

    long countByTitleId(Long titleId);



}
