package com.example.library.converters;

import com.example.library.models.Book;
import com.example.library.models.dto.BookRequestDto;
import com.example.library.models.dto.BookResponseDto;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {
    public BookResponseDto convertToDTO(Book book) {
        BookResponseDto bookDTO = new BookResponseDto();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthors(book.getAuthors());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setPublicationYear(book.getPublicationYear());
        bookDTO.setBorrow(book.getClient() != null );
        return bookDTO;
    }

    public Book convertToEntity(BookRequestDto bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setPublisher(bookDTO.getPublisher());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setClient(null);
        book.setBorrowDate(null);
        return book;
    }
}
