package com.example.library.models.dto;

import com.example.library.models.Author;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {

    @Schema(description = "book's id", example = "16261")
    private Long id;

    @Schema(description = "book's title", example = "Potop")
    private String title;

    @Schema(description = "book's author")
    private Author author;

    @Schema(description = "book's publisher", example = "PWN")
    private String publisher;

    @Schema(description = "book's publication year", example = "1886")
    private int publicationYear;

    @Schema(description = "is book borrowed", example = "false")
    private boolean isBorrow;
}
