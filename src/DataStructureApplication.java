import structures.*;

/**
 * Created by tsmj2 on 4/3/18.
 */
public class DataStructureApplication {
    public static void main(String[] args) {
//        linkedListTest();
        binarySearchTreeTest();
    }

    private static void binarySearchTreeTest() {
        MyBinarySearchTree tree = new MyBinarySearchTree<String>(30, "");
        tree.insert(10, "");
        tree.insert(4, "");
        tree.insert(1, "");
        tree.insert(56, "");
        tree.insert(47, "Item 1");
        tree.insert(47, "Item 2");
        tree.insert(32, "Target");
        tree.insert(29, "");
        tree.insert(15, "");

        tree.printTree();
    }

    private static void linkedListTest() {
        MyLinkedList list = new MyLinkedList<String>("Linked List");

        list.addFirst("This");
        list.addLast("is");
        list.addLast("dope");
        list.addLast("af");
        list.addLast("yo");
        list.printList("Original list");

        list.chopHead();
        list.printList("Chop Head");

        list.deleteAt(3);
        list.printList("Delete at index 3");

        list.addFirst("My");
        list.printList("Add first");

        list.addAt("as fuck", 4);
        list.printList("Add at 4");

        list.chopTail();
        list.printList("Chop Tail");

        System.out.println("The list has a length of: " + list.length());
    }

}
