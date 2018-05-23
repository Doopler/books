package org.books.api.controller;


import org.books.api.model.AuthorRate;
import org.books.api.model.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksController {


    @RequestMapping(value = "/book/{isbn}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook(@PathVariable("isbn") String isbn){
        return null;
    }


    @RequestMapping(value = "/category/{categoryName}/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooksByCategory(@PathVariable("categoryName") String categoryName){
        return null;
    }


    @RequestMapping(value = "/rating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorRate> getAuthorsRating(){
        return null;
    }


}
