/* Задание 2
В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.*/

package com.itvdn.javaProfessional.petrov.lesson005.homeWork;

import java.util.ArrayList;
import java.util.List;

public class Test002 {
    private static final Character[] ENDS_OF_SENTENCE = {'.', '!', '?'};
    private static final Character[] PUNCTUATIONS = {
            ' ', '\\', '"', '#', '$', '%', '&', '\'',
            '(', ')', '*', '+', ',', '-', '.', '/', ':',
            ';', '<', '=', '>', '@', '[', ']', '^',
            '_', '`', '{', '|', '}', '~'
    };
    private static final String EMPTY = "";

    private static int getNextIndex(String string, int fromIndex) {
        int indexResult = string.length();
        boolean isIndex = false;
        for (Character symbol : ENDS_OF_SENTENCE) {
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
            list.add(text.substring(firstIndex, ++lastIndex));
            firstIndex = lastIndex;
        }
        if (firstIndex < text.length()) {
            list.add(text.substring(firstIndex));
        }
        return list;
    }

    public static String sentencesToText(List<String> sentences) {
        StringBuilder text = new StringBuilder();
        for (String sentence : sentences) {
            text.append(sentence);
        }
        return text.toString();
    }

    public static int getFirstIndexPunctuation(String string) {
        int indexResult = string.length();
        for (Character symbol : PUNCTUATIONS) {
            int index = string.indexOf(symbol);
            if (index != -1 && index < indexResult) {
                indexResult = index;
            }
        }
        return indexResult;
    }

    public static int getLastIndexPunctuation(String string) {
        int indexResult = 0;
        for (Character symbol : PUNCTUATIONS) {
            int index = string.lastIndexOf(symbol);
            if (index != -1 && index > indexResult) {
                indexResult = index;
            }
        }
        return indexResult;
    }

    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static String replaceEndsOfSentence(String string) {
        for (Character symbol : ENDS_OF_SENTENCE) {
            string = string.replace(String.valueOf(symbol), EMPTY);
        }
        return string.trim();
    }

    public static String changeWords(String sentence) {
        String str = replaceEndsOfSentence(sentence);
        String firstWord = str.substring(0, getFirstIndexPunctuation(str)).trim();
        String lastWord = str.substring(getLastIndexPunctuation(str)).trim();
        sentence = sentence.replaceFirst(firstWord, lastWord);
        sentence = reverse(sentence).replaceFirst(reverse(lastWord), reverse(firstWord));
        return reverse(sentence);
    }

    public static List<String> changeWords(List<String> sentences) {
        List<String> newSentences = new ArrayList<>();
        for (String sentence : sentences) {
            newSentences.add(changeWords(sentence));
        }
        return newSentences;
    }

    public static void main(String[] args) {
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry!! Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        List<String> sentences = textToSentences(text);
        String newText = sentencesToText(changeWords(sentences));
        System.out.println(text);
        System.out.println(newText);
    }
}
