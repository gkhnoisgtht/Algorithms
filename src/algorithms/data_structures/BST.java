/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.data_structures;

/**
 *
 * @author DJ
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {

    private class Node {

        private final Key key;
        private Value value;
        private Node left, right;
        private int N = 0;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.value = val;
            this.N = n;
        }
    }

    private Node root;

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        if (root == null) {
            return 0;
        }
        return root.N;
    }

    public boolean contains(Key key) {
        if (isEmpty()) {
            return false;
        }
        return get(root, key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node.key == null) {
            return null;
        }
        int tmp = node.key.compareTo(key);
        if (tmp == 0) {
            return node.value;
        } else if (tmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }

    }

    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
        }
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null) {
            return new Node(key, val, 1);
        }
        int tmp = node.key.compareTo(key);
        if (tmp < 0) {
            return put(node.left, key, val);
        } else if (tmp > 0) {
            return put(node.right, key, val);
        } else {
            node.value = val;
            node.N = 1 + size(node.left) + size(node.right);
            return node;
        }
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.N;
        }
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMin() {
        if (isEmpty()) {
            return;
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        if (isEmpty()) {
            return null;
        }
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Key max() {
        if (isEmpty()) {
            return null;
        }
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

}
