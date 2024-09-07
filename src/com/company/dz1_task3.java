package com.company;
import java.util.Scanner;
public class dz1_task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую цифру:");
        int digit1 = scanner.nextInt();

        System.out.println("Введите вторую цифру:");
        int digit2 = scanner.nextInt();

        System.out.println("Введите третью цифру:");
        int digit3 = scanner.nextInt();

        int result = digit1 * 100 + digit2 * 10 + digit3;
        System.out.println("Полученное число: " + result);
    }
}
