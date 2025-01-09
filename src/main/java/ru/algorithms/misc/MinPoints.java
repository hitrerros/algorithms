package ru.algorithms.misc;

import ru.algorithms.Pair;

import java.util.*;



/*
По данным n отрезкам необходимо найти множество точек минимального размера, для которого каждый из отрезков
содержит хотя бы одну из точек.
 */


public class MinPoints {

    static List<Integer> pointsTask(List<Pair<Integer,Integer>> pairs) {

        List<Integer> foundPoints = new ArrayList<>();
        int currentPoint = -1;

        pairs.sort(Comparator.comparing(Pair::getValue));
        for (Pair<Integer, Integer> pair : pairs) {
            if (currentPoint < pair.getKey()) {
                currentPoint = pair.getValue();
                foundPoints.add(currentPoint);
            }
        }
            return foundPoints;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.next());
        List<Pair<Integer,Integer>> s = new ArrayList<>(num);

        for (int i=0;i<num;i++) {
            int left = Integer.parseInt(scanner.next());
            int right = Integer.parseInt(scanner.next());
            s.add(new Pair<>(left,right));
        }

        List<Integer> result = pointsTask(s);
        System.out.println(result.size());
        result.forEach(k-> System.out.print(k + " "));
    }

}
