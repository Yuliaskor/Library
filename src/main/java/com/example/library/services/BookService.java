package com.example.library.services;

import com.example.library.converters.BookConverter;
import com.example.library.models.Author;
import com.example.library.models.Book;
import com.example.library.models.dto.BookRequestDto;
import com.example.library.models.dto.BookResponseDto;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookConverter bookConverter;

    public List<BookResponseDto> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        if(books == null || books.isEmpty()){
            return new ArrayList<>();
        }
        return books
                .stream()
                .map(bookConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    public BookResponseDto addBook(BookRequestDto bookRequestDto){
        Book book = bookConverter.convertToEntity(bookRequestDto);

        Author author = authorRepository.findByName(bookRequestDto.getAuthor());
        if(author == null){
            Author a = new Author();
            a.setName(bookRequestDto.getAuthor());
            authorRepository.save(a);
            author = authorRepository.findByName(bookRequestDto.getAuthor());
        }
        book.setAuthor(author);
        bookRepository.save(book);
        return bookConverter.convertToDTO(book);
    }

    public void deleteBook(Integer id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        bookRepository.delete(book);
    }
}
