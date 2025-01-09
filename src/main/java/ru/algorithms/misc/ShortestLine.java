package ru.algorithms.misc;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 найти самые короткие отрезки между точками
 */

public class ShortestLine {

    static List<Pair<Double, Double>> shortest(List<Double> l) {
        Collections.sort(l);

        List<Pair<Double, Double>> res = new ArrayList<>();
        int i = 0;

        while (i <= l.size()-1) {
            Pair<Double, Double> p = new Pair<>(l.get(i), l.get(i + 1));
            res.add(p);
            i++;

            while (i <= l.size() - 1 && l.get(i) <= Math.max(p.getKey(), p.getValue())) i++;
        }
        return res;
    }

    public static void main(String[] args) {

        List<Double> l = new ArrayList<>();
        l.add(4.5);
        l.add(3.0);
        l.add(2.0);
        l.add(9.0);
        l.add(14.2);
        l.add(1.2);
        l.add(4.0);
        l.add(8.7);

        System.out.println(shortest(l));
    }
}

