package com.itvdn.javaProfessional.petrov.lesson015.homeWork.task003;

public class Book {
    private String title;
    private String author;
    private int countPages;

    public Book(String title, String author, int countPages) {
        this.title = title;
        this.author = author;
        this.countPages = countPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", countPages=" + countPages +
                '}';
    }
}
