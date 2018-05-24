package org.books.api.controller;

import org.books.Application;
import org.books.utils.DataUtil;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import org.books.api.model.Book;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BooksControllerTest {

    private static String RESOURCE_PATH = "src/test/resources/response/";

    private static String BOOK_FILENAME = "book.json";
    private static String BOOK_ISBN = "9780080568782";

    private static String COMPUTER_BOOKS_FILENAME = "computerBooks.json";
    private static String COMPUTER_BOOKS_CATEGORY = "Computers";


    @Autowired
    private BooksController booksController;


    @Test
    public void getSpecifiedBook() {

        Book fetchedBook = booksController.getBookByIsbn(BOOK_ISBN);
        Book referencedBook =
                DataUtil.retrieveObjectFromFile(RESOURCE_PATH + BOOK_FILENAME, Book.class).get();

        assertEquals(referencedBook, fetchedBook);

    }


    @Test
    public void getBooksByComputersCategory() {

        List<Book> fetchedBooks = booksController.getBooksByCategory(COMPUTER_BOOKS_CATEGORY);
        List<Book> referencedBooks =
                DataUtil.retrieveListOfObjectFromFile(RESOURCE_PATH + COMPUTER_BOOKS_FILENAME, Book.class).get();

        assertThat(fetchedBooks, IsIterableContainingInOrder.contains(referencedBooks.toArray()));

    }

}