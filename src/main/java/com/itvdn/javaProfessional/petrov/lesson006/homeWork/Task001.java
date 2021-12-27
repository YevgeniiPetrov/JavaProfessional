/* Задание
Напишите консольное приложение, позволяющие пользователю зарегистрироваться под «Логином»,
состоящем только из символов латинского алфавита, и пароля, состоящего из цифр и символов.*/

package com.itvdn.javaProfessional.petrov.lesson006.homeWork;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task001 {
    private static final String LOGIN_REGEX = "[a-zA-Z]{8,}";
    private static final String PASSWORD_REGEX = "[0-9a-zA-Z$&+,:;=?@#|'<>.-^*()%!]{8,}";

    public static boolean check(String regex, String input) {
        return Pattern.compile(regex).matcher(input).matches();
    }

    public static String getInputString(Scanner scanner, String message, String regex) {
        String result;
        while (true) {
            System.out.println(message);
            result = scanner.next();
            if (check(regex, result)) {
                break;
            } else {
                message = "Ввод выполнен неверно. Повторите ввод:";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String login = getInputString(sc, "Введите логин:", LOGIN_REGEX);
        String password = getInputString(sc, "Введите пароль:", PASSWORD_REGEX);
        System.out.printf("Вы зарегистрированы с логином '%s' и паролем '%s'.", login, password);
    }
}
