package com.itheima.datastructure.redblacktree;

import java.util.Stack;

public class AVLTree {
    private class Node {
        int key;
        Node left;
        Node right;
        int height;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node root;

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(int key) {
        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Stack<Node> stack = new Stack<>();

        while (current != null) {
            stack.push(current);

            if (key < current.key) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }

                current = current.left;
            } else if (key > current.key) {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }

                current = current.right;
            } else {
                return; // key already exists
            }
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            node.height = Math.max(height(node.left), height(node.right)) + 1;

            int balance = getBalance(node);

            if (balance > 1 && key < node.left.key) {
                node = rotateRight(node);
            } else if (balance < -1 && key > node.right.key) {
                node = rotateLeft(node);
            } else if (balance > 1 && key > node.left.key) {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            } else if (balance < -1 && key < node.right.key) {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }

            if (stack.isEmpty()) {
                root = node;
            } else {
                Node parent = stack.peek();

                if (parent.left == node) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
        }
    }

    public void delete(int key) {
        if (root == null) {
            return;
        }

        Node current = root;
        Node parent = null;
        Stack<Node> stack = new Stack<>();

        while (current != null && current.key != key) {
            stack.push(current);

            if (key < current.key) {
                parent = current;
                current = current.left;
            } else if (key > current.key) {
                parent = current;
                current = current.right;
            }
        }

        if (current == null) {
            return; // key not found
        }

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.left != null && current.right != null) {
            Node successor = current.right;

            while (successor.left != null) {
                stack.push(successor);
                successor = successor.left;
            }

            current.key = successor.key;
            current = successor;
            parent = stack.isEmpty() ? null : stack.peek();
        } else {
            Node child = current.left != null ? current.left : current.right;

            if (current == root) {
                root = child;
            } else if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            node.height = Math.max(height(node.left), height(node.right)) + 1;

            int balance = getBalance(node);

            if (balance > 1 && getBalance(node.left) >= 0) {
                node = rotateRight(node);
            } else if (balance > 1 && getBalance(node.left) < 0) {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            } else if (balance < -1 && getBalance(node.right) <= 0) {
                node = rotateLeft(node);
            } else if (balance < -1 && getBalance(node.right) > 0) {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }

            if (stack.isEmpty()) {
                root = node;
            } else {
                Node parent1 = stack.peek();

                if (parent1.left == node) {
                    parent1.left = node;
                } else {
                    parent1.right = node;
                }
            }
        }
    }
}