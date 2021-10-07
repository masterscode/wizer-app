package com.library.services.implementations;

import com.library.models.Book;
import com.library.models.User;
import com.library.payloads.requests.BookRequest;
import com.library.repositories.BookRepository;
import com.library.repositories.UserRepository;
import com.library.services.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final ModelMapper modelmapper = new ModelMapper();
    private final BookRepository repository;

    @Override
    public Book addBook(BookRequest request) {
        Boolean bookExists = repository.existsBookByIsbn(request.getIsbn());
        if (Boolean.TRUE.equals(bookExists)) throw new EntityExistsException();
        Book newBook = modelmapper.map(request, Book.class);
        return repository.save(newBook);
    }

    @Override
    public Book updateBook(String isbn, BookRequest request) {
        Book bookToUpdate = repository.findByIsbn(isbn).orElseThrow();
        Book updatedBook = modelmapper.map(request, Book.class);
        updatedBook.setId(bookToUpdate.getId());
        return repository.save(updatedBook);
    }

    @Override
    public Book deleteBook(Long id) {
        Book bookToDelete = repository.findById(id).orElseThrow();
        bookToDelete.setIsDeleted(true);
        return repository.save(bookToDelete);
    }


    @Override
    public List<Book> searchBook(String query) {
        return repository.findAll()
                .stream()
                .filter(book ->
                        book.getTitle().contains(query)
                                || book.getAuthor().contains(query)
                                && !book.getIsDeleted()
                ).toList();
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll()
                .stream()
                .filter(book -> !book.getIsDeleted())
                .toList();
    }

    @Override
    public Book getBookDetail(String isbn) {
        return repository.findByIsbn(isbn).orElseThrow(EntityNotFoundException::new);
    }
}
