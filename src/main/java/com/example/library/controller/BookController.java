package com.example.library.controller;

import com.example.library.exception.BookAlreadyRentedException;
import com.example.library.models.dto.BookRequestDto;
import com.example.library.models.dto.BookResponseDto;
import com.example.library.services.BookService;
import com.example.library.services.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService service;

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBook(){
        return ResponseEntity.ok(service.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> addBook(
            @RequestBody BookRequestDto book
    ) throws URISyntaxException {

        BookResponseDto savedBook = service.addBook(book);
        URI location = new URI("/api/v1/book" + savedBook.getId());
        return ResponseEntity.created(location).body(savedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
