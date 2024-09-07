package com.company;
import java.util.Scanner;
public class dz1_task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество метров:");
        double meters = scanner.nextDouble();

        System.out.println("Выберите единицу измерения для перевода (1 - мили, 2 - дюймы, 3 - ярды):");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println(meters + " метров = " + meters * 0.000621371 + " миль");
                break;
            case 2:
                System.out.println(meters + " метров = " + meters * 39.3701 + " дюймов");
                break;
            case 3:
                System.out.println(meters + " метров = " + meters * 1.09361 + " ярдов");
                break;
            default:
                System.out.println("Ошибка: неверный выбор.");
        }
    }
}
