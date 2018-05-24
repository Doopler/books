package org.books.api.repository.impl;


import org.books.api.model.AuthorRate;
import org.books.api.repository.AuthorRateRepository;
import org.books.google.model.GoogleBook;
import org.books.google.repository.GoogleBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class AuthorRateRepositoryImpl implements AuthorRateRepository {

    @Autowired
    private GoogleBookRepository googleBookRepository;

    public List<AuthorRate> getAuthorsRating(){

        Map<String,List<Double>> authorBooksRates = new HashMap<>();

        googleBookRepository.getAll().stream()
                .map(GoogleBook::getVolumeInfo)
                .filter(volumeInfo -> Objects.nonNull(volumeInfo.getAverageRating()))
                .forEach(volumeInfo ->
                        volumeInfo.getAuthors().forEach(author -> {
                            if (!authorBooksRates.containsKey(author)) {
                                authorBooksRates.put(author, new ArrayList<>());
                            }
                            authorBooksRates.get(author).add(volumeInfo.getAverageRating());
                        }));

        return authorBooksRates.entrySet().stream()
                .map(entry ->
                        new AuthorRate(
                                entry.getKey(),
                                entry.getValue()
                                        .stream()
                                        .mapToDouble(val -> val)
                                        .average()
                                        .orElse(0.0)))
                .sorted((a1, a2) -> Double.compare(a2.getAverageRating(), a1.getAverageRating()))
                .collect(Collectors.toList());
    }
}
