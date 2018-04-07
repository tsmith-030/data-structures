package structures;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tmackSickles on 4/7/18.
 */
public class MyBinarySearchTree<T> {
    private Node root;

    public MyBinarySearchTree(int key, T data) {
        this.root = new Node(key, data);
    }

    public List<T> get(int key) {
        return get(root, key);
    }

    // Avg: O(log(n)), Worst: O(n)
    private List get(Node node, int key) {
        while(node != null) {
            if(key < node.key) {
                node = node.left;
            } else if(key > node.key) {
                node = node.right;
            } else {
                return node.data;
            }
        }

        System.out.println("That key could not be located");
        return null;
    }

    public void insert(int newKey, T data) {
        insert(root, newKey, data);
    }

    // Avg: O(log(n)), Worst: O(n)
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

    public void delete(int key) {
        delete(root, key);
    }

    //TODO: WIP
    private void delete(Node node, int key) {
        if(node == null) {
            System.out.println("That key could not be located");
        }

        if(key < node.key) {
            delete(node.left, key);
        } else if (key > node.key) {
            delete(node.right, key);
        } else {

        }
        return;
    }

    // O(n) for each - has to find and print each of n elements in the tree
    public void printTree() {
        System.out.println("Tree inorder: ");
        printTreeInorder(root);

        System.out.println("\n\nTree preorder: ");
        printTreePreorder(root);

        System.out.println("\n\nTree postorder: ");
        printTreePostorder(root);
    }

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
