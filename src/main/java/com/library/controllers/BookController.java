package com.library.controllers;

import com.library.models.Book;
import com.library.payloads.requests.BookRequest;
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

    @GetMapping("/{isbn}")
    public @ResponseBody Book getBook(@PathVariable String isbn){
        return null;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> search(@RequestParam("query") String searchQuery){
        return ResponseEntity.ok(
                service.searchBook(searchQuery)
        );
    }


    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookRequest book){
        return ResponseEntity.ok(
                service.addBook(book)
        );
    }

    @PatchMapping("/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn, @Valid @RequestBody BookRequest requestBody){
        return ResponseEntity.ok(
                service.updateBook(isbn, requestBody)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> removeBook(@PathVariable Long id){
        return ResponseEntity.ok(
                service.deleteBook(id)
        );
    }
}
