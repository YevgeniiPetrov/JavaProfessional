/* Задание
Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.*/

package com.itvdn.javaProfessional.petrov.lesson005.homeWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task001 {
    private static final Character[] ENDS_OF_SENTENCES = {'.', '!', '?'};
    private static final Character SPACE = ' ';

    private static int getNextIndex(String string, int fromIndex) {
        int indexResult = string.length();
        boolean isIndex = false;
        for (Character symbol : ENDS_OF_SENTENCES) {
            int index = string.indexOf(symbol, fromIndex);
            if (index != -1 && index < indexResult) {
                indexResult = index;
                isIndex = true;
            }
        }
        return isIndex ? indexResult : -1;
    }

    public static List<String> textToSentences(String text) {
        text = text.trim();
        List<String> list = new ArrayList<>();
        int firstIndex = 0;
        int lastIndex;
        while ((lastIndex = getNextIndex(text, firstIndex)) != -1) {
            list.add(text.substring(firstIndex, ++lastIndex).trim());
            firstIndex = lastIndex;
        }
        if (firstIndex < text.length()) {
            list.add(text.substring(firstIndex).trim());
        }
        return list;
    }

    public static int getCountWords(String sentence) {
        sentence = sentence.trim();
        int count = 0;
        int firstIndex = 0;
        int lastIndex;
        while ((lastIndex = sentence.indexOf(SPACE, firstIndex)) != -1) {
            count++;
            firstIndex = ++lastIndex;
        }
        return count;
    }

    public static void main(String[] args) {
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry! Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        List<String> sentences = textToSentences(text);
        Collections.sort(sentences, (o1, o2) -> Integer.compare(getCountWords(o1), getCountWords(o2)));
        for (String sentence : sentences) {
            System.out.println(sentence.trim());
        }
    }
}
