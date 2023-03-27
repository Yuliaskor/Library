package com.example.library.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BookRequestDto {
    @JsonProperty
    private String title;
    @JsonProperty
    private String author;
    @JsonProperty
    private String publisher;
    @JsonProperty
    private int publicationYear;

}
