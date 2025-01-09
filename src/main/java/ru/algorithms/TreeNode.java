package ru.algorithms;

public class TreeNode<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T value;

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setLeft(TreeNode<T> value) {
        this.left = value;
    }

    public void setRight(TreeNode<T> value) {
        this.right = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public boolean isFull() { return this.left != null && this.right != null; }
}
