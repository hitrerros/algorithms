package ru.algorithms.misc;

import java.util.Scanner;

public class Fibonacci {

    // поиск n-го числа Фибоначчи
    static int fib(int num) {
        int[] fib = new int[num];
        for (int i = 0; i < num; i++) {
            fib[i] = (i <= 1) ? 1 : fib[i - 1] + fib[i - 2];
            System.out.print(fib[i] + " ");
        }
        System.out.println("end");
        return fib[num - 1];
    }

    // поиск n-го числа Фибоначчи без массива
    static int fib2(int num) {
        int fib = 0;
        int prev1 = 1;
        int prev2 = 0;

        int curr = 0;
        while (curr < num) {
            fib = prev2 + prev1;
            prev1 = prev2;
            prev2 = fib;
            curr++;
        }
        System.out.println();
        return fib;
    }

    // поиск последней цифры  n-го числа Фибоначчи без массива
    static int lastFib(int num) {
        int res = 0;
        int prev1 = 0;
        int prev2 = 1;

        int curr = 0;
        while (curr < num-1) {

            res = (prev1 + prev2)%10;
            prev1 = prev2;
            prev2 = res;
            System.out.print(res + " ");
            curr++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print("fibo: ");

        int i = Integer.parseInt(new Scanner(System.in).next());
        fib(i);

        System.out.println();
        System.out.println("last " + lastFib(i));



    }
}
