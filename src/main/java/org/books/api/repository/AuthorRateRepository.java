package org.books.api.repository;

import org.books.api.model.AuthorRate;
import java.util.*;

/**
 * AuthorRate repository
 */
public interface AuthorRateRepository {

    /**
     * Gets authors average rating for all their books
     *
     * @return list of author rate {@link AuthorRate}
     */
    List<AuthorRate> getAuthorsRating();
}
