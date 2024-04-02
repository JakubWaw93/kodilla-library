package com.kodilla.kodillalibrary.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookCopyNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookCopyNotFoundException exception) {
        return new ResponseEntity<>("BookCopy with given parameter doesn't exist", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TitleNotFoundException.class)
    public ResponseEntity<Object> handleTitleNotFoundException(TitleNotFoundException exception) {
        return new ResponseEntity<>("Title with given parameter doesn't exist", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ReaderNotFoundException.class)
    public ResponseEntity<Object> handleReaderNotFoundException(ReaderNotFoundException exception) {
        return new ResponseEntity<>("Reader with given parameter doesn't exist", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RentalNotFoundException.class)
    public ResponseEntity<Object> handleRentalNotFoundException(RentalNotFoundException exception) {
        return new ResponseEntity<>("Rental with given parameter doesn't exist", HttpStatus.NOT_FOUND);
    }


}
