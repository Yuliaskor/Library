package com.example.library.services;

import com.example.library.converters.BookConverter;
import com.example.library.exception.BookAlreadyRentedException;
import com.example.library.exception.BookNotRentedException;
import com.example.library.models.Book;
import com.example.library.repository.BookRepository;
import com.example.library.user.User;
import com.example.library.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final BookRepository bookRepository;
    private final UserRepository clientRepository;


    public void rentBook(Integer bookId, Integer clientId) {
        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isEmpty()){
            throw new NotFoundException("Nie znaleziono ksiązki z takim id");
        }

        if (book.get().getClient() != null){
            throw new BookAlreadyRentedException();
        }
        Optional<User> client = clientRepository.findById(clientId);

        if (client.isEmpty()){
            throw new NotFoundException("Nie znaleziono clienta z takim id");
        }
        book.get().setClient(client.get());
        book.get().setBorrowDate(LocalDate.now());
        bookRepository.deleteById(bookId);
        bookRepository.save(book.get());
    }


    public void returnBook(Integer bookId, Integer clientId) {
        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isEmpty()){
            throw new NotFoundException("Nie znaleziono ksiązki z takim id");
        }

        if (book.get().getClient() == null){
            throw new BookNotRentedException(bookId);
        }
        Optional<User> client = clientRepository.findById(clientId);

        if (client.isEmpty()){
            throw new NotFoundException("Nie znaleziono clienta z takim id");
        }
        book.get().setClient(null);
        bookRepository.deleteById(bookId);
        bookRepository.save(book.get());
    }
}
