package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.domain.BookCopyDto;
import com.kodilla.kodillalibrary.mapper.BookCopyMapper;
import com.kodilla.kodillalibrary.service.BookCopyService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bookcopies")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BookCopyController {

    private final BookCopyService service;
    private final BookCopyMapper mapper;
    private final Logger LOGGER = LoggerFactory.getLogger(BookCopyController.class);

    @GetMapping(value = "/title/{titleId}")
    public ResponseEntity<List<BookCopyDto>> getBookCopiesByTitleId(@PathVariable Long titleId) throws BookCopyNotFoundException {
        LOGGER.info("This Title has: " + service.countByTitleId(titleId) + " copies");
        return ResponseEntity.ok(mapper.mapToBookCopyDtoList(service.getAllBookCopiesByTitleId(titleId)));
    }

    @GetMapping(value = "/{bookCopyId}")
    public ResponseEntity<BookCopyDto> getBookCopy(@PathVariable Long bookCopyId) throws BookCopyNotFoundException {
        return ResponseEntity.ok(mapper.mapToBookCopyDto(service.getBookCopy(bookCopyId)));
    }

    @PutMapping
    public ResponseEntity<BookCopyDto> updateBookCopy(@RequestBody BookCopyDto bookCopyDto) {
        BookCopy bookCopy = mapper.mapToBookCopy(bookCopyDto);
        BookCopy savedBookCopy = service.saveBookCopy(bookCopy);
        return ResponseEntity.ok(mapper.mapToBookCopyDto(savedBookCopy));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBookCopy(@RequestBody BookCopyDto bookCopyDto) {
        BookCopy bookCopy = mapper.mapToBookCopy(bookCopyDto);
        service.saveBookCopy(bookCopy);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{bookCopyId}")
    public ResponseEntity<Void> deleteBookCopy(@PathVariable Long bookCopyId) throws BookCopyNotFoundException {
        service.deleteBookCopy(bookCopyId);
        return ResponseEntity.ok().build();
    }




}
