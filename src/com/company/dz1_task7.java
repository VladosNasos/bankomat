package com.company;
import java.util.Scanner;
public class dz1_task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число диапазона:");
        int num1 = scanner.nextInt();

        System.out.println("Введите второе число диапазона:");
        int num2 = scanner.nextInt();

        // Нормализация границ диапазона
        int start = Math.min(num1, num2);
        int end = Math.max(num1, num2);

        System.out.println("Нечетные числа в диапазоне от " + start + " до " + end + ":");
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
