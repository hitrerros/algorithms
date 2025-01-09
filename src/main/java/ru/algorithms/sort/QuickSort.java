package ru.algorithms.sort;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class QuickSort {

    static int lessThanOrEqual(int val, int[] arr) {
        int found = 0;
        for (int el : arr) {
            if (el <= val) found++;
            else break;
        }
        return found;
    }

    static int lessThan(int val, int[] arr) {
        int found = 0;
        for (int el : arr) {
            if (el < val) found++;
            else break;
        }
        return found;
    }


    static void swap(final int[] arr, final int pos1, final int pos2) {
        final int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }


    static int partition(int[] a, int left, int right) {
        int x = a[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (a[i] <= x) {
                j++;
                swap(a, i, j);
            }
        }

        swap(a, left, j);
        return j;
    }

    static void quickSort(int[] a, int left, int right) {
        if (left >= right) return;

        int m = partition(a, left, right);
        quickSort(a, left, m - 1);
        quickSort(a, m + 1, right);
    }

    public static void main(String[] args) {
//        int[] a = new int[]{13, 1, 15, 23, 4, 5, 71};
//        quickSort(a,0,a.length-1);
//        System.out.println();
//

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String[] numDotsAndLines = scanner.next().split(" ");
        int numLines = parseInt(numDotsAndLines[0]);
        int numDots = parseInt(numDotsAndLines[1]);

        int[] begins = new int[numLines];
        int[] ends = new int[numLines];

        for (int i = 0; i < numLines; i++) {
            String[] xAndY = scanner.next().split(" ");
            begins[i] = parseInt(xAndY[0]);
            ends[i] = parseInt(xAndY[1]);
        }

        quickSort(begins, 0, begins.length - 1);
        quickSort(ends, 0, ends.length - 1);

        String[] dots = scanner.next().split(" ");

        StringBuilder sb = new StringBuilder();
        for (String sdot : dots) {
            int dot = parseInt(sdot);
            int lefts = lessThanOrEqual(dot, begins);
            int rights = lessThan(dot, ends);

            int sum = lefts - rights;
            sb.append(sum).append(" ");
        }
        System.out.println(sb.toString().trim());
    }


}
