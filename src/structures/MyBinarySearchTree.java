package structures;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tmackSickles on 4/7/18.
 */
public class MyBinarySearchTree<T> {
    private Node root;
    private int depth;

    public MyBinarySearchTree(int key, T data) {
        this.root = new Node(key, data);
    }

    public void insert(int newKey, T data) {
        insert(root, newKey, data);
    }

    // O(log(n))
    private void insert(Node node, int key, T data) {
        if (key < node.key) {
            if (node.left == null) {
                node.left = new Node(key, data);
            } else {
                insert(node.left, key, data);
            }
        }

        if (key > node.key) {
            if (node.right == null) {
                node.right = new Node(key, data);
            } else {
                insert(node.right, key, data);
            }
        }

        if(key == node.key) {
            node.data.add(data);
            node.count++;
        }

        return;
    }

    //TODO: print counts if count > 1
    public void printTree() {
        System.out.println("Tree inorder: ");
        printTreeInorder(root);

        System.out.println("\n\nTree preorder: ");
        printTreePreorder(root);

        System.out.println("\n\nTree postorder: ");
        printTreePostorder(root);
    }

    // O(log(n))
    private void printTreeInorder(Node node) {
        if (node == null) {
            return;
        }

        printTreeInorder(node.left);
        System.out.print(node.key +
                ((node.count > 1) ? "[" + node.count + "] " : " "));
        printTreeInorder(node.right);
    }


    private void printTreePreorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.key +
                ((node.count > 1) ? "[" + node.count + "] " : " "));
        printTreePreorder(node.left);
        printTreePreorder(node.right);
    }

    private void printTreePostorder(Node node) {
        if (node == null) {
            return;
        }

        printTreePostorder(node.left);
        printTreePostorder(node.right);
        System.out.print(node.key +
                ((node.count > 1) ? "[" + node.count + "] " : " "));
    }

    private static class Node<T> {
        int key;
        List<T> data = new LinkedList<>();
        int count;
        Node left;
        Node right;

        public Node(int key, T data) {
            this.key = key;
            this.data.add(data);
            this.left = null;
            this.right = null;
            this.count = 1;
        }
    }
}
