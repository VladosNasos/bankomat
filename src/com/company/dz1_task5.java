package com.company;
import java.util.Scanner;
public class dz1_task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер месяца (от 1 до 12):");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Ошибка: введите номер месяца от 1 до 12.");
        } else if (month == 12 || month == 1 || month == 2) {
            System.out.println("Winter");
        } else if (month >= 3 && month <= 5) {
            System.out.println("Spring");
        } else if (month >= 6 && month <= 8) {
            System.out.println("Summer");
        } else {
            System.out.println("Autumn");
        }
    }
}
