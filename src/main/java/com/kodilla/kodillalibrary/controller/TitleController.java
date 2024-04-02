package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.controller.exception.TitleNotFoundException;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.domain.TitleDto;
import com.kodilla.kodillalibrary.mapper.TitleMapper;
import com.kodilla.kodillalibrary.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/titles")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TitleController {

    private final TitleService service;
    private final TitleMapper mapper;

    @GetMapping
    public ResponseEntity<List<TitleDto>> getTitles() {
        List<Title> titles = service.getAllTitles();
        return ResponseEntity.ok(mapper.mapToTitleDtoList(titles));
    }

    @GetMapping(value = "/author/{author}")
    public ResponseEntity<List<TitleDto>> getTitlesByAuthor(@PathVariable String author) {
        List<Title> titles = service.getAllTitlesByAuthor(author);
        return ResponseEntity.ok(mapper.mapToTitleDtoList(titles));
    }

    @GetMapping(value = "/theTitle/{theTitle}")
    public ResponseEntity<List<TitleDto>> getTitlesByTheTitle(@PathVariable String theTitle) {
        List<Title> titles = service.getAllTitlesByTheTitle(theTitle);
        return ResponseEntity.ok(mapper.mapToTitleDtoList(titles));
    }

    @GetMapping(value = "/{titleId}")
    public ResponseEntity<TitleDto> getTitle(@PathVariable Long titleId) throws TitleNotFoundException {
        return ResponseEntity.ok(mapper.mapToTitleDto(service.getTitle(titleId)));
    }

    @PutMapping
    public ResponseEntity<TitleDto> updateTitle(@RequestBody TitleDto titleDto) {
        Title title = mapper.mapToTitle(titleDto);
        Title savedTitle = service.saveTitle(title);
        return ResponseEntity.ok(mapper.mapToTitleDto(savedTitle));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTitle(@RequestBody TitleDto titleDto) {
        Title title = mapper.mapToTitle(titleDto);
        service.saveTitle(title);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{titleId}")
    public ResponseEntity<Void> deleteTitle(@PathVariable Long titleId) throws TitleNotFoundException {
        service.deleteTitle(titleId);
        return ResponseEntity.ok().build();
    }

}
