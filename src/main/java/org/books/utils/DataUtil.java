package org.books.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class DataUtil {

    public <T> Optional<T> retrieveObjectFromFile(String filename, final Class<T> clazz) {
        T result = null;
        try {
           result = getMapper().readValue(new File(filename), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(result);
    }

    public <T> Optional<List<T>> retrieveListOfObjectFromFile(String filename, final Class<T> clazz) {
        ObjectMapper mapper = getMapper();
        List<T> result = null;
        try {
            result = mapper.readValue(new File(filename), mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(result);
    }

    private static ObjectMapper getMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }
}
