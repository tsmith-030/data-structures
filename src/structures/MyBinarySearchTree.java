package structures;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by tmackSickles on 4/7/18.
 */
public class MyBinarySearchTree {
    private Node root;

    public MyBinarySearchTree(int key) {
        this.root = new Node(key);
    }

    public void insert(int newKey) {
        Node parent = traverse(root, newKey);

        if(newKey < parent.key) {
            parent.left = new Node(newKey);
        } else if (newKey > parent.key) {
            parent.right = new Node(newKey);
        } else {
            parent.count++;
        }
    }

    //TODO: print counts if count > 1
    public void printTree() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t" + root.key);
        System.out.println("\t\t\t\t\t\t\t\t   / \\");

        int i = 9;
        int j = 9;

        while(root.left != null) {
            printNextNode(root.left, i);
            i--;
        }
    }

    private void printNextNode(Node node, int count) {
        String tabs = IntStream.range(0, count).mapToObj(i -> "\t").collect(Collectors.joining(""));

        System.out.println(tabs + node.left.key + "   " + node.right.key);
    }

    private Node traverse(Node node, int key) {
        while(key > node.key && node.right != null) {
            traverse(node.right, key);
        }

        while(key < node.key && node.left != null) {
            traverse(node.left, key);
        }
        return node;
    }

    private static class Node {
        int key;
        int count;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            count = 1;
        }
    }
}
