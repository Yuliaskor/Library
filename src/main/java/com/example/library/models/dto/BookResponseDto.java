package com.example.library.models.dto;

import com.example.library.models.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {

    private Long id;

    private String title;

    private Author author;

    private String publisher;

    private int publicationYear;

    private boolean isBorrow;
}
