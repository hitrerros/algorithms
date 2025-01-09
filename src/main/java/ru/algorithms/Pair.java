package ru.algorithms;

public class Pair<K, V>  {
    private final K key;
    private  V value;

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public Pair(K var1, V var2) {
        this.key = var1;
        this.value = var2;
    }

    public void setValue(V var2) {
          value = var2;
    }
}
