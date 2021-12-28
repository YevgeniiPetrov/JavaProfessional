/* Задание 3
Спроектируйте и разработайте метод, определяющий, сколько времени прошло с заданной даты.
С помощью этого методы выведите в консоль, сколько времени прошло с вашего дня рождения в удобном
для восприятия виде, например: «Вам исполнилось 20 лет, 3 месяца, 18 дней, 4 часа, 5 минут и 10 секунд».*/

package com.itvdn.javaProfessional.petrov.lesson006.homeWork;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Task003 {
    private static final String DATE_FORMAT = "dd.MM.yyyy";

    public static LocalDateTime getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите дату в формате %s:\n", DATE_FORMAT);
        LocalDate date;
        while (true) {
            try {
                date = LocalDate.parse(scanner.nextLine(), formatter);
                break;
            } catch (DateTimeParseException e) {
                e.printStackTrace();
                System.out.printf("Ввод выполнен неверно. Повторите ввод даты в формате %s^\n", DATE_FORMAT);
            }
        }
        return date.atStartOfDay();
    }

    public static String getDurationFromNow(LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        String dateStr = dateTime.format(formatter);
        long years = dateTime.until(now, ChronoUnit.YEARS);
        dateTime = dateTime.plusYears(years);
        long months = dateTime.until(now, ChronoUnit.MONTHS);
        dateTime = dateTime.plusMonths(months);
        long days = dateTime.until(now, ChronoUnit.DAYS);
        dateTime = dateTime.plusDays(days);
        long hours = dateTime.until(now, ChronoUnit.HOURS);
        dateTime = dateTime.plusHours(hours);
        long minutes = dateTime.until(now, ChronoUnit.MINUTES);
        dateTime = dateTime.plusMinutes(minutes);
        long seconds = dateTime.until(now, ChronoUnit.SECONDS);
        return String.format("С даты %s прошло %d лет, %d месяцев, %d дней, %d часов, %d минут и %d секунд.",
                dateStr, years, months, days, hours, minutes, seconds);
    }

    public static void main(String[] args) {
        System.out.println(getDurationFromNow(getDateTime()));
    }
}
