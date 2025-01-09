package ru.algorithms.misc;

import java.util.Scanner;

/*
 Алгоритм Евклид для поиска Наименьшего Общего Делителя
 */

public class Euclid {

    static int calculate(int a, int b) {
        if (a==0) return b;
        if (b==0) return a;
        if (a>=b) return calculate(a%b,b);
        else return calculate(a,b%a);
      }


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int a = Integer.parseInt(s.next());
        int b = Integer.parseInt(s.next());

        System.out.println(calculate(a ,b));
    }
}
