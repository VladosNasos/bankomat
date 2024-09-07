package com.company;
import java.util.Scanner;
public class dz1_task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите значение:");
        double value = scanner.nextDouble();

        System.out.println("Введите процент:");
        double percent = scanner.nextDouble();

        double result = (value * percent) / 100;
        System.out.println(percent + " процентов от " + value + " = " + result);
    }
}
