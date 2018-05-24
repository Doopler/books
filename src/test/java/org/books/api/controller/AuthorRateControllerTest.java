package org.books.api.controller;

import org.books.Application;
import org.books.api.model.AuthorRate;
import org.books.utils.DataUtil;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
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
public class AuthorRateControllerTest {

    private static String RESOURCE_PATH = "src/test/resources/response/";
    private static String RATING_FILENAME = "rating.json";


    @Autowired
    private AuthorRateController authorRateController;


    @Test
    public void getAuthorsRatings() {

        List<AuthorRate> fetchedAuthorsRates = authorRateController.getAuthorsRating();
        List<AuthorRate> referencedAuthorsRates =
                DataUtil.retrieveListOfObjectFromFile(RESOURCE_PATH + RATING_FILENAME, AuthorRate.class).get();

        assertThat(fetchedAuthorsRates, IsIterableContainingInOrder.contains(referencedAuthorsRates.toArray()));

    }

}