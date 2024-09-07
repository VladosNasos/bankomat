package com.company;
import java.util.ArrayList;
import java.util.Random;
public class dz1_task10 {
    public static void main(String[] args) {
        int[] array = new int[20]; // Заполним массив из 20 случайных чисел
        Random random = new Random();

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> positiveNumbers = new ArrayList<>();
        ArrayList<Integer> negativeNumbers = new ArrayList<>();

        // Заполняем массив случайными числами и разбиваем на подмассивы
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(201) - 100; // Числа от -100 до 100
            System.out.print(array[i] + " "); // Для наглядности выводим массив

            if (array[i] % 2 == 0) {
                evenNumbers.add(array[i]);
            } else {
                oddNumbers.add(array[i]);
            }

            if (array[i] > 0) {
                positiveNumbers.add(array[i]);
            } else if (array[i] < 0) {
                negativeNumbers.add(array[i]);
            }
        }

        System.out.println("\nМассив четных чисел: " + evenNumbers);
        System.out.println("Массив нечетных чисел: " + oddNumbers);
        System.out.println("Массив положительных чисел: " + positiveNumbers);
        System.out.println("Массив отрицательных чисел: " + negativeNumbers);
    }
}
