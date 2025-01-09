package ru.algorithms.huffman;

import ru.algorithms.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.Scanner;

import static java.lang.Integer.parseInt;


/*
В первой строке входного файла заданы два целых числа
k и l  через пробел — количество различных букв, встречающихся в строке, и размер получившейся закодированной строки, соответственно. В следующих
k строках записаны коды букв в формате "letter: code". Ни один код не является префиксом другого. Буквы могут быть перечислены в любом порядке.
В качестве букв могут встречаться лишь строчные буквы латинского алфавита; каждая из этих букв встречается в строке хотя бы один раз. Наконец,
 в последней строке записана закодированная строка. Исходная строка и коды всех букв непусты.
 */

public class OptimalDecoder {

    static List<Pair<String, Character>> vocabulary = new ArrayList<>();

    static Character foundToken(String token) {
        return vocabulary.stream().
                filter(k -> token.equals(k.getKey())).
                findFirst().
                map(Pair::getValue).
                orElse(null);
    }


    static String decode(String s, int stringSize) {
        StringBuilder decodedString = new StringBuilder();
        int i = 0;
        while (i < stringSize) {
            StringBuilder token = new StringBuilder();
            token.append(s.charAt(i));
            Character value;
            while ((value = foundToken(token.toString())) == null) {
                token.append(s.charAt(++i));
            }
            decodedString.append(value);
            i++;
        }
        return decodedString.toString();
    }

    public static void main(String[] args) {
        String s;
        int numLetters = 0, stringSize = 0;

        // k & l
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        s = scanner.next();

        String[] s1 = s.split(" ");
        numLetters = parseInt(s1[0]);
        stringSize = parseInt(s1[1]);


        // vocabulary
        for (int i = 0; i < numLetters; i++) {
            s = scanner.next();
            String[] token = s.split(": ");
            vocabulary.add(new Pair<>(token[1], token[0].charAt(0)));
        }

        vocabulary.sort(Comparator.comparing(Pair::getKey));
        // string
        String toDecode = scanner.next();
        System.out.println(decode(toDecode, stringSize));
    }
}
