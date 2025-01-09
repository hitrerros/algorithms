package ru.algorithms.misc;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
По данному числу  1≤n≤10^9  найдите максимальное число k, для которого n
n можно представить как сумму k различных натуральных слагаемых. Выведите в первой строке число k, во второй —
k слагаемых.
 */

public class FindMaxSummator {

    static void summator(int n) {
        int curr = 0;
        int deduct = n;
        List<Integer> array = new LinkedList<>();

        while (deduct >= 0) {
            curr++;
            if (deduct - curr > 0) {
                deduct -= curr;
                array.add(curr);
            } else {
                if (array.isEmpty()) {
                    array.add(curr);
                } else {
                    int last = array.getLast();

                    if (array.contains(deduct)) {
                        array.removeLast();
                        array.add(last + deduct);
                    } else {
                        array.add(curr);
                    }
                }
                break;
            }
        }
        System.out.println(array.size());
        array.forEach(k -> System.out.print(k + " "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.next());

        summator(num);
    }


}
