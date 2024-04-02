package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.domain.BookCopyDto;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.domain.TitleDto;
import com.kodilla.kodillalibrary.repository.BookCopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TitleMapper {

    private final BookCopyRepository bookCopyRepository;

    public Title mapToTitle(final TitleDto titleDto) {
        Title title = new Title();
        title.setId(titleDto.getId());
        title.setTheTitle(titleDto.getTheTitle());
        title.setAuthor(titleDto.getAuthor());
        title.setPublicationYear(titleDto.getPublicationYear());
        List<BookCopy> bookCopies = titleDto.getBookCopiesIds().stream()
                .map(bookCopyRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        title.setBookCopies(bookCopies);
        return title;
    }

    public TitleDto mapToTitleDto(final Title title) {
        TitleDto titleDto = new TitleDto();
        titleDto.setId(title.getId());
        titleDto.setTheTitle(title.getTheTitle());
        titleDto.setAuthor(title.getAuthor());
        titleDto.setPublicationYear(title.getPublicationYear());
        List<Long> bookCopiesIds = title.getBookCopies().stream().map(BookCopy::getId).toList();
        titleDto.setBookCopiesIds(bookCopiesIds);
        return titleDto;
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> titleList) {
        return titleList.stream()
                .map(this::mapToTitleDto)
                .toList();
    }

}
