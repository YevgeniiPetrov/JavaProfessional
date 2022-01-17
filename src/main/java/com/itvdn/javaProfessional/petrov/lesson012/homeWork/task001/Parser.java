package com.itvdn.javaProfessional.petrov.lesson012.homeWork.task001;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Parser {
    public static <T> T[] parseJson(String url, Class<T[]> clazz) throws IOException {
        return new ObjectMapper().readValue(new URL(url), clazz);
    }
}
