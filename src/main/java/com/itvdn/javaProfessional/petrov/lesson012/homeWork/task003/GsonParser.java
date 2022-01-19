package com.itvdn.javaProfessional.petrov.lesson012.homeWork.task003;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GsonParser {
    public static void toJson(String string, String filePath) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        JsonObject jsonObject = gson.fromJson(string, JsonObject.class);
        Writer writer= new FileWriter(filePath);
        gson.toJson(jsonObject, writer);
        writer.flush();
        writer.close();
    }
}
