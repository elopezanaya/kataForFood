package com.kata;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class Kata {

    public static boolean isUniqueCharsOnly(String input) {
        char[] chars = input.toCharArray();
        Set<Character> cache = new HashSet<Character>();
        for (char letter : chars) {
            if (cache.contains(letter)) {
                return false;
            }
            cache.add(letter);
        }
        return true;
    }

    static class Node {
        boolean root;
        String value;
        Node left;
        Node right;

        public Node withNodeRight(Node right) {

            this.right = right;
            return this;
        }

        public Node withNodeLeft(Node left) {

            this.left = left;

            return this;
        }

        public Node withValue(String value) {

            this.value = value;

            return this;
        }

        public Node withRoot(boolean root) {

            this.root = root;
            return this;
        }
    }

    public static boolean isMirror(Node node) {

        if (node.left.value.equals(node.right.value)) {

            if (goLeft(node.left, node.right)) {

                return goRight(node.left, node.right);
            }
        }
        return false;
    }

    public static boolean goRight(Node node1, Node node2) {
        if (node1 != null && node2 != null) {
            if (node1.value.equals(node2.value)) {
                return goRight(node1.right, node2.right);
            }
            return false;
        }
        return true;
    }

    public static boolean goLeft(Node node1, Node node2) {
        if (node1 != null && node2 != null) {
            if (node1.value.equals(node2.value)) {
                return goLeft(node1.left, node2.left);
            }
            return false;
        }
        return true;
    }
}