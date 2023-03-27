package com.example.library.controller;

import com.example.library.services.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rentals")
@Tag(name = "Rental Controller")
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/{bookId}/{clientId}")
    @Operation(summary = "Rent book", description = "Rent given book to given client")
    public ResponseEntity<Void> rentBook(@PathVariable Integer bookId, @PathVariable Integer clientId) {
        rentalService.rentBook(bookId, clientId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("return/{bookId}/{clientId}")
    @Operation(summary = "Return book", description = "Return given book from given client")
    public ResponseEntity<Void> returnBook(@PathVariable Integer bookId, @PathVariable Integer clientId) {
        rentalService.returnBook(bookId, clientId);
        return ResponseEntity.ok().build();
    }
}
