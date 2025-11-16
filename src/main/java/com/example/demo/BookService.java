package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public Book createBook(Book book) {
        book.setId((long)(books.size() + 1));
        books.add(book);
        return book;
    }

    public List<Book> getBooks() {
        return books;
    }
}
