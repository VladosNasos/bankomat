package com.company;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class dz1_task12 {
    public static void main(String[] args) {
        Integer[] array = {3, 7, 1, 9, 2, 8};

        System.out.println("Выберите тип сортировки (1 - по возрастанию, 2 - по убыванию):");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        sortArray(array, choice == 1);

        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    // Метод для сортировки массива
    public static void sortArray(Integer[] array, boolean ascending) {
        if (ascending) {
            Arrays.sort(array);
        } else {
            Arrays.sort(array, Collections.reverseOrder());
        }
    }
}
