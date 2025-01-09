package ru.algorithms.heap;

import ru.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.Integer.MIN_VALUE;
import static java.util.concurrent.ThreadLocalRandom.current;

/*

Первая строка входа содержит число операций 1≤n≤10^5. Каждая из последующих
n строк задают операцию одного из следующих двух типов:
Insert x , где 0≤x≤10^9   — целое число;
ExtractMax.
Первая операция добавляет число
x в очередь с приоритетами, вторая — извлекает максимальное число и выводит его.

 */

class TreeNodeWithHead<T> extends TreeNode<T> {
    private TreeNodeWithHead<T> head;

    public TreeNodeWithHead(T value) {
        super(value, null, null);
    }

    public void setHead(TreeNodeWithHead<T> head) {
        this.head = head;
    }

    public TreeNodeWithHead<T> getHead() {
        return head;
    }

}

public class PrioritizedHeap {

    private TreeNodeWithHead<Integer> curr = null;
    private TreeNodeWithHead<Integer> first = null;
    private final List<TreeNodeWithHead<Integer>> tops = new ArrayList<>();

    private void swap(TreeNode<Integer> nodeFrom, TreeNode<Integer> nodeTo) {
        var buff = nodeFrom.getValue();
        nodeFrom.setValue(nodeTo.getValue());
        nodeTo.setValue(buff);
    }

    private void siftUp(TreeNodeWithHead<Integer> node) {
        TreeNodeWithHead<Integer> head = node.getHead();
        if (head != null && head.getValue() <= node.getValue()) {
            swap(node, head);
            siftUp(head);
        }
    }

    private void siftDown(TreeNode<Integer> node) {
        Optional<TreeNode<Integer>> maxNode =
                Stream.of(node.getLeft(), node.getRight())
                        .filter(Objects::nonNull)
                        .max(Comparator.comparing(TreeNode::getValue));

        maxNode.ifPresent(max -> {
            if (node.getValue() < max.getValue()) {
                swap(node, max);
                siftDown(max);
            }
        });

        var nodeWithHead = (TreeNodeWithHead<Integer>) node;
        if (node.getValue() == MIN_VALUE) {
            tops.remove(nodeWithHead);
            if (nodeWithHead.getHead() != null) {
                var head = nodeWithHead.getHead();
                if (head.getLeft() == nodeWithHead) {
                    head.setLeft(null);
                } else head.setRight(null);
            } else {
                first = null;
                curr = null;
            }
        }
    }

    public void insert(int value) {
        if (first == null) {
            first = new TreeNodeWithHead<>(value);
            curr = first;
            tops.add(first);
        } else {
            if (curr.isFull()) {
                curr = tops.get(current().nextInt(0, tops.size() - 1));
                insert(value);
            } else {
                var node = new TreeNodeWithHead<>(value);
                node.setHead(curr);
                if (curr.getLeft() == null) {
                    curr.setLeft(node);
                    tops.add(node);
                } else if (curr.getRight() == null) {
                    curr.setRight(node);
                    tops.add(node);
                    tops.remove(curr);
                }
                siftUp(node);
            }
        }
    }

    public int extractMax() {
        var ret = first.getValue();
        first.setValue(Integer.MIN_VALUE);
        siftDown(first);
        return ret;
    }

    public static void main(String[] args) {
        for (int times = 0; times < 100; times++) {
            var heap = new PrioritizedHeap();

            int max = 0;
            int maxOp = current().nextInt(1, 500);
            for (int i = 0; i < maxOp; i++) {
                int randomNum = current().nextInt(0, 3299);
                max = Math.max(randomNum, max);
                heap.insert(randomNum);
            }
            int calcMax = heap.extractMax();
            if (max != calcMax) {
                System.out.println("alert");
            }
        }
    }
}
