package com.example.library.controller;

import com.example.library.exception.BookAlreadyRentedException;
import com.example.library.exception.BookNotRentedException;
import com.example.library.services.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rentals")
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/{bookId}/{clientId}")
    public ResponseEntity<Void> rentBook(@PathVariable Integer bookId, @PathVariable Integer clientId) {
        try {
            rentalService.rentBook(bookId, clientId);
            return ResponseEntity.ok().build();
        } catch (BookAlreadyRentedException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("return/{bookId}/{clientId}")
    public ResponseEntity<Void> returnBook(@PathVariable Integer bookId, @PathVariable Integer clientId) {
        try {
            rentalService.returnBook(bookId, clientId);
            return ResponseEntity.ok().build();
        } catch (BookNotRentedException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }  catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
