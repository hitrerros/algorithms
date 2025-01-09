package ru.algorithms.misc;

import ru.algorithms.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

 Задача непрерывный рюкзак.
 Данo: Количество предметов и вместимость
 Найти: Максимальную стоимость частей предметов , которые можно поместить в рюкзак

 */

public class BackPack {

    static double bestBackPack(int maxNum, int maxVolume, List<Pair<Integer, Integer>> src) {
        double calculatedSum = 0;
        int restVolume = maxVolume;

        src.sort((k, v) -> {
            double v1 = (double) v.getKey() / v.getValue();
            double k1 = (double) k.getKey() / k.getValue();

            return Double.compare(v1, k1);
        });

        for (Pair<Integer, Integer> p : src) {
            if (restVolume >= p.getValue()) {
                calculatedSum += p.getKey();
                restVolume -= p.getValue();
            } else {
                double unit = (double) p.getKey() / (double) p.getValue();
                calculatedSum += unit * restVolume;
                break;
            }

        }

        return calculatedSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.next());
        int maxAmount = Integer.parseInt(scanner.next());
        List<Pair<Integer, Integer>> s = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            int left = Integer.parseInt(scanner.next());
            int right = Integer.parseInt(scanner.next());
            s.add(new Pair<>(left, right));
        }

        double result = bestBackPack(num, maxAmount, s);
        System.out.println(result);
    }
}


