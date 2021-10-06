package com.library.services;


import com.library.models.Book;
import com.library.payloads.requests.BookRequest;
import com.library.payloads.requests.BorrowBookRequest;

import java.util.List;

/**
 * The API will be used to
 * add, update, delete, lend books
 * to users and search for books in the library.
 */
public interface BookService {
    Book addBook(BookRequest bookRequest);
    Book updateBook(Long id, BookRequest request);
    Book deleteBook(Long id);
    List<Book> borrowBook(BorrowBookRequest borrowRequest);
    List<Book> searchBook(String searchQuery);
    List<Book> getAllBooks();

}
