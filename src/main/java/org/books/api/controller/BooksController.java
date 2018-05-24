package org.books.api.controller;


import org.books.api.model.Book;
import org.books.api.repository.BookRepository;
import org.books.error.ResultsNotFoundException;
import org.books.utils.JsonGetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksController {

    @Autowired
    private BookRepository bookRepository;


    @JsonGetMapping("/book/{isbn}")
    public Book getBookByIsbn(@PathVariable("isbn") String isbn) throws ResultsNotFoundException {
        return bookRepository.getBookByIsbn(isbn);
    }

    @JsonGetMapping("/category/{categoryName}/books")
    public List<Book> getBooksByCategory(@PathVariable("categoryName") String categoryName){
        return bookRepository.getBooksByCategory(categoryName);
    }

}