package structures;

/**
 * Created by tmackSickles on 4/7/18.
 */
public class MyBinarySearchTree {
    private Node root;
    private int depth;

    public MyBinarySearchTree(int key) {
        this.root = new Node(key);
    }

    public void insert(int newKey) {
        insert(root, newKey);
    }

    private void insert(Node node, int key) {
        if(key < node.key && node.left != null) {
            insert(node.left, key);
        }
        if(node.right != null && key > node.key) {
            insert(node.right, key);
        }
        if(key < node.key && node.left == null) {
            node.left = new Node(key);
        }
        if(key > node.key && node.right == null) {
            node.right = new Node(key);
        }

        return;
    }

    //TODO: print counts if count > 1
    public void printTree() {
        System.out.println("Tree in preorder: ");
        printTreePreorder(root);
    }

    private void printTreePreorder(Node node) {
        if(node == null) {
            return;
        }

        printTreePreorder(node.left);
        System.out.print(node.key + " ");
        printTreePreorder(node.right);
    }

    private static class Node {
        int key;
        int count;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
            count = 1;
        }
    }
}
