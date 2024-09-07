package com.company;

public class dz1_task11 {
    public static void main(String[] args) {
        drawLine(5, "horizontal", '*');
        System.out.println();
        drawLine(3, "vertical", '#');
    }

    // Метод для рисования линии
    public static void drawLine(int length, String direction, char symbol) {
        if (direction.equalsIgnoreCase("horizontal")) {
            for (int i = 0; i < length; i++) {
                System.out.print(symbol);
            }
            System.out.println();
        } else if (direction.equalsIgnoreCase("vertical")) {
            for (int i = 0; i < length; i++) {
                System.out.println(symbol);
            }
        } else {
            System.out.println("Ошибка: направление должно быть 'horizontal' или 'vertical'.");
        }
    }
}
