package com.company;

import java.util.Scanner;

public class dz1_task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число диапазона:");
        int start = scanner.nextInt();

        System.out.println("Введите второе число диапазона:");
        int end = scanner.nextInt();

        // Нормализация диапазона
        int min = Math.min(start, end);
        int max = Math.max(start, end);

        for (int i = min; i <= max; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i + "*" + j + " = " + (i * j) + " ");
            }
            System.out.println();
        }
    }
}
