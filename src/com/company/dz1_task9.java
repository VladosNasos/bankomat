package com.company;
import java.util.Random;
public class dz1_task9 {
    public static void main(String[] args) {
        int[] array = new int[20]; // Заполним массив из 20 случайных чисел
        Random random = new Random();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        // Заполнение массива и поиск значений
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(201) - 100; // Случайные числа от -100 до 100
            System.out.print(array[i] + " "); // Для наглядности выводим массив
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > 0) {
                positiveCount++;
            } else if (array[i] < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        System.out.println("\nМинимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Количество положительных элементов: " + positiveCount);
        System.out.println("Количество отрицательных элементов: " + negativeCount);
        System.out.println("Количество нулей: " + zeroCount);
    }
}
