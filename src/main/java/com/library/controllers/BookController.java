package com.library.controllers;

import com.library.models.Book;
import com.library.payloads.requests.BookRequest;
import com.library.payloads.requests.BorrowBookRequest;
import com.library.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(
                service.getAllBooks()
        );
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id){
        return null;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> search(@RequestParam("query") String searchQuery){
        return ResponseEntity.ok(
                service.searchBook(searchQuery)
        );
    }

    @PatchMapping("/borrow")
    public ResponseEntity<List<Book>> borrowBook(@Valid @RequestBody BorrowBookRequest request) {
        return ResponseEntity.ok(
                service.borrowBook(request)
        );
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookRequest book){
        return ResponseEntity.ok(
                service.addBook(book)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody BookRequest requestBody){
        return ResponseEntity.ok(
                service.updateBook(id, requestBody)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> removeBook(@PathVariable Long id){
        return ResponseEntity.ok(
                service.deleteBook(id)
        );
    }
}
