package org.books.api.model;


import lombok.Data;

@Data
public class AuthorRate {

    private String author;
    private Double averageRating;

}
