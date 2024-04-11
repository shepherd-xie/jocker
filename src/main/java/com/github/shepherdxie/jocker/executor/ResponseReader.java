package com.github.shepherdxie.jocker.executor;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;

import java.io.IOException;

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

}
