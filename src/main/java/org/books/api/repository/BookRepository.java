package org.books.api.repository;


import org.books.api.model.Book;
import org.books.error.ResultsNotFoundException;
import java.util.List;

/**
 * Book repository
 */
public interface BookRepository {

    /**
     * Gets book by isbn
     *
     * @param isbn isbn number
     * @return book {@link Book}
     * @throws ResultsNotFoundException if book is not founded
     */
    Book getBookByIsbn(String isbn) throws ResultsNotFoundException;

    /**
     * Gets list of books by category name
     *
     * @param categoryName name of category
     * @return list of books {@link Book}
     */
    List<Book> getBooksByCategory(String categoryName);

}
