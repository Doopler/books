package org.books.google.repository;

import org.books.YAMLConfig;
import org.books.google.model.GoogleBook;
import org.books.google.model.GoogleData;
import org.books.utils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GoogleBookRepository {

    @Autowired
    private YAMLConfig config;


    public List<GoogleBook> getAll() {
        return DataUtil.retrieveObjectFromFile(config.getBooksPath(), GoogleData.class)
                .map(GoogleData::getItems)
                .orElse(new ArrayList<>());

    }

}
