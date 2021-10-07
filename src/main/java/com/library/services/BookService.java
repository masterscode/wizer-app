package com.library.services;


import com.library.models.Book;
import com.library.payloads.requests.BookRequest;

import java.util.List;
import java.util.Optional;

/**
 * The API will be used to
 * add, update, delete, lend books
 * to users and search for books in the library.
 */
public interface BookService {
    Book addBook(BookRequest bookRequest);
    Book updateBook(String isbn, BookRequest request);
    Book deleteBook(Long id);
    List<Book> searchBook(String searchQuery);
    List<Book> getAllBooks();
    Book getBookDetail(String isbn);

}
