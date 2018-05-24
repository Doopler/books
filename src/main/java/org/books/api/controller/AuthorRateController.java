package org.books.api.controller;

import org.books.api.model.AuthorRate;
import org.books.api.repository.AuthorRateRepository;
import org.books.utils.JsonGetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorRateController {


    @Autowired
    private AuthorRateRepository authorRateRepository;


    @JsonGetMapping("/rating")
    public List<AuthorRate> getAuthorsRating(){
        return authorRateRepository.getAuthorsRating();
    }
}