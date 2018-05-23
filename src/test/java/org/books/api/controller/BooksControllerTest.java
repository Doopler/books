package org.books.api.controller;

import org.books.api.model.AuthorRate;
import org.books.utils.DataUtil;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import org.books.api.model.Book;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BooksControllerTest {

    private static String RESOURCE_PATH = "src/test/resources/response/";

    private static String BOOK_FILENAME = "book.json";
    private static String BOOK_ISBN = "9780080568782";

    private static String COMPUTER_BOOKS_FILENAME = "computerBooks.json";
    private static String COMPUTER_BOOKS_CATEGORY = "Computers";

    private static String RATING_FILENAME = "rating.json";


    @Autowired
    private BooksController booksController;


    @Test
    public void getSpecifiedBook() throws IOException {

        Book referencedBook = DataUtil.retrieveObjectFromFile(RESOURCE_PATH + BOOK_FILENAME, Book.class);
        Book fetchedBook = booksController.getBook(BOOK_ISBN);

        assertEquals(referencedBook, fetchedBook);

    }


    @Test
    public void getBooksByComputersCategory() throws IOException {

        List<Book> referencedBooks = DataUtil.retrieveListOfObjectFromFile(RESOURCE_PATH + COMPUTER_BOOKS_FILENAME, Book.class);
        List<Book> fetchedBooks = booksController.getBooksByCategory(COMPUTER_BOOKS_CATEGORY);

        assertThat(fetchedBooks, IsIterableContainingInOrder.contains(referencedBooks.toArray()));

    }


    @Test
    public void getAuthorsRatings() throws IOException {

        List<AuthorRate> referencedAuthorsRates = DataUtil.retrieveListOfObjectFromFile(RESOURCE_PATH + RATING_FILENAME, AuthorRate.class);
        List<AuthorRate> fetchedAuthorsRates = booksController.getAuthorsRating();

        assertThat(fetchedAuthorsRates, IsIterableContainingInOrder.contains(referencedAuthorsRates.toArray()));

    }

}