package com.itvdn.javaProfessional.petrov.lesson012.homeWork.task002;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonParser {
    public static void toJson(String string, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), objectMapper.readTree(string));
    }
}
