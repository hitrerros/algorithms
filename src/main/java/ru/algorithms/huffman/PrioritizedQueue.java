package ru.algorithms.huffman;

import ru.algorithms.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class PrioritizedQueue<T> {
    private final Map<Integer, LinkedList<T>> storage = new HashMap<>();
    private int minPriority = 0;

    void push(T val, int priority) {
        LinkedList<T> ts = storage.get(priority);
        if (ts == null) {
            ts = new LinkedList<>();
            ts.addLast(val);
            storage.put(priority, ts);
            minPriority = minPriority == 0 ? priority : Math.min(minPriority, priority);
        } else {
            ts.add(val);
        }
    }

    public int size() {
        int size = 0;
        for (var s : storage.values()) {
            size += s.size();
        }
        return size;
    }

    Pair<Integer, T> popMin() {
        if (minPriority == 0) return null;
        T val = storage.get(minPriority).poll();
        LinkedList<T> list = storage.get(minPriority);
        int retrievedPriority = minPriority;

        if (list.isEmpty()) {
            storage.remove(minPriority);
            minPriority = storage.keySet().stream().min(Integer::compareTo).orElse(0);
        }
        return new Pair<>(retrievedPriority, val);
    }

    boolean isEmpty() {
        return minPriority == 0;
    }
}
