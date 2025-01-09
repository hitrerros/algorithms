package ru.algorithms.misc;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

/*
В первой строке даны целое число и массив [1…n] из n различных натуральных чисел
порядке возрастания, во второй — целое число k натуральных чисел.
Для каждого
i от 1 до k необходимо вывести индекс 1≤j≤n, для которого
−1, если такого j нет.
 */

public class BinarySearch {
    static int search(int num, int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == num) {
                return m + 1;
            } else if (arr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1;
        int[] arr2;

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String[] arrToFind = scanner.next().split(" ");
        String[] arrToBeFind = scanner.next().split(" ");

        arr1 = new int[parseInt(arrToFind[0])];
        arr2 = new int[parseInt(arrToBeFind[0])];

        boolean first = false;
        int i = 0;
        for (String s : arrToFind) {
             if (!first) { first = true; continue; } else {
                 arr1[i++] = parseInt(s);
             }
        }

        first = false;
        i = 0;
        for (String s : arrToBeFind) {
            if (!first) { first = true; continue; } else {
                arr2[i++] = parseInt(s);
            }
        }


        first = false;
        for (int val : arr2) {
            if (first) {
                System.out.print(" ");
            } else {
                first = true;
            }

            int  found = search(val,arr1);
            System.out.print(found);
        }

    }
}
