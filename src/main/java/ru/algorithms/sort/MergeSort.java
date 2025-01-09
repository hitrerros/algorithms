package ru.algorithms.sort;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

/*
Первая строка содержит число,  вторая — массив
Необходимо посчитать число пар индексов
1≤i<j≤n, для которых A[i]>A[j].
(Такая пара элементов называется инверсией массива. Количество инверсий в массиве
 */

public class MergeSort {

    static long inverted = 0;

    static int[] cut(int[] a, int left, int right) {
        int[] r = new int[right - left];
        for (int i = 0; i < r.length; i++) {
            r[i] = a[i + left];
        }
        return r;
    }

    static int[] mergeSort(int[] a) {
        if (a.length > 1) {
            int middle = a.length / 2;
            int[] x = cut(a, 0, middle);
            int[] y = cut(a, middle, a.length);
            return merge(mergeSort(x), mergeSort(y));
        } else {
            return a;
        }
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {

        int[] res = new int[leftArray.length + rightArray.length];
        int l = 0;
        int r = 0;
        int m = 0;

        while (true) {
            int leftVal;
            int rightVal;

            if (l < leftArray.length) {
                leftVal = leftArray[l];
            } else {
                for (int x = r; x <= rightArray.length - 1; x++) res[m++] = rightArray[x];
                break;
            }

            if (r < rightArray.length) {
                rightVal = rightArray[r];
            } else {
                for (int x = l; x <= leftArray.length - 1; x++) res[m++] = leftArray[x];
                break;
            }

            if (leftVal <= rightVal) {
                res[m++] = leftVal;
                l++;
            } else {
                inverted += leftArray.length - l;
                res[m++] = rightVal;
                r++;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int numDig = parseInt(scanner.next());

        int []arr = new int[numDig];
        int i = 0;
        String[] arrToBeFind = scanner.next().split(" ");
        for (String s : arrToBeFind) {
             arr[i++] = parseInt(s);
        }
        mergeSort(arr);
        System.out.println(inverted);
    }
}
