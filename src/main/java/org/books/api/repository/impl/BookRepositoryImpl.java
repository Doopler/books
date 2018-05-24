package org.books.api.repository.impl;

import org.books.api.model.Book;
import org.books.api.repository.BookRepository;
import org.books.error.ResultsNotFoundException;
import org.books.google.model.GoogleBook;
import org.books.google.repository.GoogleBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class BookRepositoryImpl implements BookRepository {


    @Autowired
    private GoogleBookRepository googleBookRepository;


    @Override
    public Book getBookByIsbn(String isbn) throws ResultsNotFoundException {
        return googleBookRepository.getAll().stream()
                .map(GoogleBook::getVolumeInfo)
                .map(Book::new)
                .filter(book -> Objects.nonNull(book.getIsbn()))
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow(ResultsNotFoundException::new);
    }


    @Override
    public List<Book> getBooksByCategory(String categoryName) {
        return googleBookRepository.getAll().stream()
                .map(GoogleBook::getVolumeInfo)
                .map(Book::new)
                .filter(book -> Objects.nonNull(book.getCategories()))
                .filter(book -> book.getCategories().contains(categoryName))
                .collect(Collectors.toList());
    }
}