package org.books.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

@UtilityClass
public class DataUtil {

    public <T> T retrieveObjectFromFile(String filename, final Class<T> clazz) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper.readValue(new File(filename), clazz);
    }

    public <T> List<T> retrieveListOfObjectFromFile(String filename, final Class<T> clazz) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper.readValue(new File(filename), mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }
}
