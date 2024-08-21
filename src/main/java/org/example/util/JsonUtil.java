package org.example.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.util.List;

@UtilityClass
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> void writeGson(T t, String path) {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(new File(path), t);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("No cards found!");
        }
    }

    public static <T> List<T> readGson(String path, TypeReference<List<T>> typeReference) {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return objectMapper.readValue(new File(path), typeReference);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Card not read!");
        }
    }
}
