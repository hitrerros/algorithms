package ru.algorithms.huffman;

import ru.algorithms.Pair;
import ru.algorithms.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/*
Задача на программирование: кодирование Хаффмана
о данной непустой строке s длины не более
10^4, состоящей из строчных букв латинского алфавита, постройте оптимальный беспрефиксный код. В первой строке выведите количество
различных букв  k, встречающихся в строке, и размер получившейся закодированной строки. В следующих
k строках запишите коды букв в формате "letter: code". В последней строке выведите закодированную строку.
 */


public class OptimalCoder {
    PrioritizedQueue<TreeNode<String>> queue = new PrioritizedQueue<>();
    TreeNode<String> currNode = null;
    HashMap<Character,String> vocabulary = new HashMap<>();

    private void buildTree(){
        Pair<Integer, TreeNode<String>> el = queue.popMin();
        if (queue.isEmpty()) return;

        Pair<Integer, TreeNode<String>> adjacentEl = queue.popMin();

        TreeNode<String> leftNode = el.getValue();
        TreeNode<String> rightNode = adjacentEl.getValue();
        String newValue = leftNode.getValue() + (rightNode !=null ?  rightNode.getValue() : "");

        currNode = new TreeNode<>(newValue,leftNode,rightNode);
        queue.push(currNode,adjacentEl.getKey()+el.getKey());
        buildTree();
    }

    void encode(String s) {
        List<Pair<Character, Integer>> freq = new LinkedList<>();
        String[] arrayString = s.split("");

        Stream.of(arrayString).forEach(k -> {
            Character ch = k.charAt(0);
            Optional<Pair<Character, Integer>> p = freq.
                    stream().
                    filter(let -> let.getKey().equals(ch)).findFirst();
            if (p.isEmpty()) {
                freq.add(new Pair<>(ch, 1));
            } else {
                Pair<Character, Integer> curr = p.get();
                curr.setValue(curr.getValue() + 1);
            }
        });

        freq.sort((k,v)->v.getValue().compareTo(k.getValue()));
        freq.forEach(k->queue.push(new TreeNode<>(k.getKey().toString(),null,null),k.getValue()));

        if (queue.size()>1) {
            buildTree();
        } else if (queue.size()==1) {
           currNode = new TreeNode<>(queue.popMin().getValue().getValue(),null,null);
        } else return;

        buildVocabulary(currNode,"");

        // output
        StringBuilder output = new StringBuilder();

        int total = 0;
        for (var token : arrayString) {
            String code = vocabulary.get(token.charAt(0));
            total += code.length();
            output.append(code);
        }

        System.out.println(vocabulary.size() + " " + total);
        vocabulary.forEach((k,v)->System.out.println("ch: " + k + ", code: " + v  ));
        System.out.println(output);
  }

    private void buildVocabulary(TreeNode<String> currNode,String step) {
        if (currNode.isLeaf()) {
            vocabulary.put(currNode.getValue().charAt(0),step.isEmpty()?"0":step);
        } else {
            buildVocabulary(currNode.getLeft(),step + "0");
            buildVocabulary(currNode.getRight(),step + "1");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String s = scanner.next();
        if (!s.isEmpty()) new OptimalCoder().encode(s);
    }
}
