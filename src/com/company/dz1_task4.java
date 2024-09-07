package com.company;
import java.util.Scanner;
public class dz1_task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите шестизначное число:");
        String number = scanner.nextLine();

        if (number.length() != 6) {
            System.out.println("Ошибка: введите шестизначное число.");
        } else {
            // Меняем первую и шестую цифры, а также вторую и пятую цифры
            char[] digits = number.toCharArray();
            char temp = digits[0];
            digits[0] = digits[5];
            digits[5] = temp;

            temp = digits[1];
            digits[1] = digits[4];
            digits[4] = temp;

            String result = new String(digits);
            System.out.println("Результат: " + result);
        }
    }
}
