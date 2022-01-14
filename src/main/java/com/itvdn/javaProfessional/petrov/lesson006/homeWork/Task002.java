/* Задание 2
Напишите шуточную программу «Дешифратор», которая бы в текстовом файле могла бы заменить все
предлоги на слово «Java».
*/

package com.itvdn.javaProfessional.petrov.lesson006.homeWork;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task002 {
    private static final String[] PREPOSITIONS = {"to", "at", "on", "in", "at", "for", "by", "from"};
    private static final String JAVA = "Java";
    
    public static String getRegex() {
        StringBuilder regex = new StringBuilder();
        for (int i = 0; i < PREPOSITIONS.length; i++) {
            regex.append(PREPOSITIONS[i]);
            if (i != PREPOSITIONS.length - 1) {
                regex.append("|");
            }
        }
        return regex.toString();
    }

    public static List<String> readFile(File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void writeFile(File file, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String decode(String line) {
        return line.replaceAll("(\\b)(?i)(" + getRegex() + ")(\\b)", JAVA);
    }

    public static List<String> decode(List<String> lines) {
        List<String> newLines = new ArrayList<>();
        for (String line : lines) {
            newLines.add(decode(line));
        }
        return newLines;
    }

    public static void main(String[] args) {
        File fileIn = new File("../JavaProfessional/src/main/resources/decoder1.txt");
        File fileOut = new File("../JavaProfessional/src/main/resources/decoder2.txt");
        List<String> lines = readFile(fileIn);
        writeFile(fileOut, decode(lines));
    }
}
