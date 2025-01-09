package ru.algorithms.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class SortCount {

    static int[] sortCount(int [] arr) {
        int []sorted = new int[arr.length];
        Map<Integer,Integer> freq = new HashMap<>();
        for ( int el : arr) freq.merge(el,1,(k,v)->k+1);

        int i = 0;
        var keys = freq.keySet().stream().sorted().toList();
        for (var key : keys) {
            for (int x = 0; x < freq.get(key); x++) {
                sorted[i++] = key;
            }
        }
    return sorted;
    }


    public static void main(String[] args) {
        //int[] a = new int[]{2,2,3,9,9};

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int numEls = parseInt(scanner.next());

        String[] numbers = scanner.next().split(" ");

        int i = 0;
        int[] a = new int[numEls];
        for (String number : numbers) {
            a[i++] = parseInt(number);
        }

        int[] s  = sortCount(a);

        StringBuilder sb = new StringBuilder();
        for (int el : s ) sb.append(el).append(" ");
        System.out.println(sb.toString().trim());

    }

}
