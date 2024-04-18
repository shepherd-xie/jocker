package com.github.shepherdxie.jocker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

/**
 * @author Shepherd Xie
 * @since 2024/4/11
 */
public class ResponseReader {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> T readValue(Response response, Class<T> valueType) throws IOException {
        if (response.isSuccessful()) {
            String jsonResult = response.body().string();
            T value = OBJECT_MAPPER.readValue(jsonResult, valueType);
            return value;
        } else {
            System.out.println("Request failed: " + response);
        }
        return null;
    }

    public static <T> T readValue(String response, Class<T> valueType) {
        try {
            return OBJECT_MAPPER.readValue(response, valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> readList(String response, Class<T> valueType) {
        try {
            TypeFactory typeFactory = OBJECT_MAPPER.getTypeFactory();
            return OBJECT_MAPPER.readValue(response, typeFactory.defaultInstance().constructCollectionType(List.class, valueType));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
