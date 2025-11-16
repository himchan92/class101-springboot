package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookService.createBook(book));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updateBook) {
//        for(Book book : books) {
//            book.setTitle(updateBook.getTitle());
//            return ResponseEntity.ok(book);
//        }
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
//        for(Iterator<Book> iterator = books.iterator(); iterator.hasNext();) {
//            Book book = iterator.next();
//            if(book.getId().equals(id)) {
//                iterator.remove();
//                return ResponseEntity.noContent().build();
//            }
//        }
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
}