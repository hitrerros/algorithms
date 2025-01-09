package ru.algorithms.heap;

import java.util.*;

import static java.lang.Integer.parseInt;


public class StandardLib {

    public static void main(String[] args) {
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>(
                Collections.reverseOrder());


        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int numCmd = parseInt(scanner.next());

        for (int i = 0; i < numCmd; i++) {
            String cmd = scanner.next();
            String[] s = cmd.split(" ");
            if ("Insert".equals(s[0])) {
                pQueue.add(parseInt(s[1]));
            } else  if ("ExtractMax".equals(s[0]))
            {
                int max = pQueue.poll();
                System.out.println(max);
            }
        }



    }

}
