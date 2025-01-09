package ru.algorithms.misc;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Sequence {

    static int listBottomUp(int[] a) {
        int[] cache = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            cache[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((a[i] % a[j]) == 0 && cache[j] + 1 > cache[i]) {
                    cache[i] = cache[j] + 1;
                }
            }

        }
        int max = 0;
        for (int j : cache) {
            max = Math.max(max, j);
        }
        return max;
    }

    public static void main(String[] args) {
        // int[] a = new int[]{1, 2, 2, 4, 6, 12, 36, 8, 7, 9, 16, 48, 48, 3, 9, 48, 96};
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int numDig = parseInt(scanner.next());

        int[] arr = new int[numDig];
        int i = 0;
        String[] arrToBeFind = scanner.next().split(" ");
        for (String s : arrToBeFind) {
            arr[i++] = parseInt(s);
        }


        System.out.println(listBottomUp(arr));
    }
}
